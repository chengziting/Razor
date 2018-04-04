package com.chengziting.razor.web.core.interceptors;

import com.chengziting.razor.service.IUsersService;
import com.chengziting.razor.web.core.annotations.Administrator;
import com.chengziting.razor.web.core.annotations.WithoutVerify;
import com.chengziting.razor.model.persistent.Users;
import com.chengziting.razor.service.IRolesService;
import com.chengziting.razor.utils.common.IGlobalKey;
import com.chengziting.razor.utils.common.SymmetricEncoder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 2018-01-16.
 */
public class AuthorizationInterceptor implements HandlerInterceptor {

    private static Logger logger = Logger.getLogger(AuthorizationInterceptor.class);
    @Autowired
    private IRolesService roleService;
    @Autowired
    private IUsersService userService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("AuthorizationInterceptor");

        if((handler instanceof ResourceHttpRequestHandler) ||
                ((HandlerMethod)handler).getMethodAnnotation(WithoutVerify.class) != null ||
                (((HandlerMethod) handler).getMethod().getDeclaringClass().isAnnotationPresent(WithoutVerify.class))){
            return true;
        }


        Cookie[]cookies = request.getCookies();

        String userCookieValue = null;
        for (Cookie cookie:cookies) {
            if(cookie.getName().equals(IGlobalKey.COOKIE_USER_LOGIN_KEY)){
                userCookieValue = cookie.getValue();
                break;
            }
        }

        if(userCookieValue == null) {
            String currentUrl = request.getRequestURL().toString();
            response.sendRedirect(request.getContextPath() + "/account/login?backto=" + currentUrl);
            return false;
        }

        adminCheck(request,(HandlerMethod)handler,userCookieValue);

        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    private void adminCheck(HttpServletRequest request,HandlerMethod handler,String userCookie){
        Administrator adminMethod = handler.getMethodAnnotation(Administrator.class);
        Administrator adminClass = handler.getMethod().getDeclaringClass().getAnnotation(Administrator.class);
        if(adminMethod == null && adminClass == null){
            return;
        }

        Set<String> roleSet = new HashSet<String>();
        if(adminClass != null) {
            for (String r : adminClass.roles()) {
                roleSet.add(r);
            }
        }
        if(adminMethod != null) {
            for (String r : adminMethod.roles()) {
                roleSet.add(r);
            }
        }

        String originalValue = SymmetricEncoder.AESDncode(userCookie);
        String userName = originalValue.split(IGlobalKey.COOKIE_USER_LOGIN_SEPARATOR)[1];
        String password = originalValue.split(IGlobalKey.COOKIE_USER_LOGIN_SEPARATOR)[0];
        Users user = userService.get(userName,SymmetricEncoder.AESDncode(password));

        logger.info("admin:"+userName);
    }
}