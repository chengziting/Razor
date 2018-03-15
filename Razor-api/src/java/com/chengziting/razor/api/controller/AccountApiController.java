package com.chengziting.razor.api.controller;

import com.chengziting.razor.model.persistent.UserInfo;
import com.chengziting.razor.service.IUserInfoService;
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
    private IUserInfoService userInfoService;

    @RequestMapping("/test")
    @ResponseBody
    public String test(String p){
        List<UserInfo> userInfoList = userInfoService.getList();
        return "test "+userInfoList.get(0).getName();
    }
}
