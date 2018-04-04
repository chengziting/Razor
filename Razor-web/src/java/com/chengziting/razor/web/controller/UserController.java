package com.chengziting.razor.web.controller;

import com.chengziting.razor.model.persistent.Users;
import com.chengziting.razor.model.system.PagingModel;
import com.chengziting.razor.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by user on 2018-03-02.
 */
@Controller
@RequestMapping("users")
public class UserController {
    @Autowired
    private IUsersService usersService;
    @RequestMapping("list")
    public ModelAndView listUsers(){
        ModelAndView mv = new ModelAndView("/users/list");
        return mv;
    }
}
