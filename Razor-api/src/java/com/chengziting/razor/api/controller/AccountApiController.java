package com.chengziting.razor.api.controller;

import com.chengziting.razor.model.persistent.Users;
import com.chengziting.razor.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by user on 2018-03-13.
 */
@Controller
@RequestMapping(value = "/api/account")
public class AccountApiController {

    @Autowired
    private IUsersService usersService;

    @RequestMapping("/test")
    @ResponseBody
    public String test(String p){
        List<Users> usersList = usersService.getList();
        return "test "+ usersList.get(0).getName();
    }
}
