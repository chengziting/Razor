package com.chengziting.razor.web.controller;

import com.chengziting.razor.model.persistent.Roles;
import com.chengziting.razor.model.persistent.Users;
import com.chengziting.razor.service.IRolesService;
import com.chengziting.razor.service.IUserRoleService;
import com.chengziting.razor.service.IUsersService;
import com.chengziting.razor.utils.common.CookieUtils;
import com.chengziting.razor.utils.common.IGlobalKey;
import com.chengziting.razor.utils.common.SymmetricEncoder;
import com.chengziting.razor.core.exception.ServiceException;
import com.chengziting.razor.web.model.ViewModel;
import com.chengziting.razor.web.model.vm.LoginModel;
import com.chengziting.razor.web.model.vm.RegisterModel;
import com.chengziting.razor.web.model.vm.ResultModel;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 2018-01-16.
 */
@Controller
@RequestMapping("account")
public class AccountController {

    @Autowired
    private IRolesService rolesService;
    @Autowired
    private IUsersService usersService;
    @Autowired
    private IUserRoleService userRoleService;

    @RequestMapping("login")
    @Transactional
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView("/account/login");
        List<Users> userses = usersService.getList();
        Users users1 = userses.get(0);
        List<Roles> roles = users1.getRoles();
        Roles role = roles.get(0);
        return mv;
    }
    @RequestMapping("register")
    public ModelAndView register(){
        ModelAndView mv = new ModelAndView("/account/register");
        ViewModel vm = new ViewModel();
        vm.setTitle("Register");
        mv.addObject("viewdata",vm);
        List<Users> usersList = usersService.getList();
        List<Roles> rolesList = rolesService.getList();
        if(usersList.size()>0){
            Users users = usersList.get(0);
            if(users.getRoles().size() > 0){
                Roles role = users.getRoles().get(0);
                String name = role.getName();
            }
        }

        return mv;
    }

    @RequestMapping(value = "doRegister",method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public String doRegister(@RequestBody RegisterModel model, HttpServletResponse response/*, HttpServletRequest request*/) throws ServiceException {
        ResultModel<String> rm = new ResultModel<String>();
        if(model.hasError()){
            rm.setMessage(model.getErrorMsg());
            rm.setRedirect("");
            return new Gson().toJson(rm);
        }
        Map<String,Object> condition = new HashMap<String, Object>();
        condition.put("name",IRolesService.ROLE_USER);
        Roles role = rolesService.getFirst(condition);
        if(role!=null){
            try {
//                Session session = SpringContextUtils.getCurrentSession();
                Users users = new Users();
                users.setName(model.getName());
                users.setEmail(model.getEmail());
                users.setPassword(SymmetricEncoder.AESEncode(model.getPassword()));
                String id = usersService.save(users);
                CookieUtils.writeCookie(response,SymmetricEncoder.AESEncode(users.getPassword()+ IGlobalKey.COOKIE_USER_LOGIN_SEPARATOR+id));

                rm.setMessage("Register success");
                rm.setRedirect("/main/index");
                rm.setSuccess(true);
            }catch (Exception ex){
                rm.setMessage("Register error");
                rm.setData(ex.getMessage());
                throw new ServiceException();
            }
        }

        return new Gson().toJson(rm);
    }

    @RequestMapping(value = "doLogin",method = RequestMethod.POST)
    @ResponseBody
    public String doLogin(@RequestBody LoginModel model, HttpServletRequest request){

        String kaptchaExpected = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        return kaptchaExpected;
    }
}
