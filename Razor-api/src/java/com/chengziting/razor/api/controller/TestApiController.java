package com.chengziting.razor.api.controller;

import com.chengziting.razor.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by user on 2018-03-12.
 */
@Controller
@RequestMapping("/api/testapi")
public class TestApiController {
    @Autowired
    private IUserInfoService userInfoService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public String test(String p){
        return "test"+p;
    }

    @RequestMapping(value = "/testpost",method = RequestMethod.POST)
    @ResponseBody
    public String testPost(String p){
        return "testPost"+p;
    }
}
