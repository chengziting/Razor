package com.chengziting.razor.api.core.intercepters;

import com.chengziting.razor.model.persistent.Users;
import com.chengziting.razor.service.IUsersService;
import com.chengziting.razor.utils.common.IGlobalKey;
import com.chengziting.razor.utils.common.SymmetricEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by user on 2018-03-13.
 */
public class IdentityInterceptor implements HandlerInterceptor {
    @Autowired
    private IUsersService usersService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("Start verify identity.");
        Cookie[]cookies = request.getCookies();

        if(cookies == null)
            return false;

        String userCookieValue = null;
        for (Cookie cookie:cookies) {
            if(cookie.getName().equals(IGlobalKey.COOKIE_USER_LOGIN_KEY)){
                userCookieValue = cookie.getValue();
                break;
            }
        }
        if(userCookieValue == null){
            PrintWriter writer = response.getWriter();
            writer.write("Request Denied!");
            writer.flush();
            return false;
        }
        String originalValue = SymmetricEncoder.AESDncode(userCookieValue);
        String userName = originalValue.split(IGlobalKey.COOKIE_USER_LOGIN_SEPARATOR)[1];
        String password = originalValue.split(IGlobalKey.COOKIE_USER_LOGIN_SEPARATOR)[0];
        Users user = usersService.get(userName,password);
        if(user == null)
            return false;
        else return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
