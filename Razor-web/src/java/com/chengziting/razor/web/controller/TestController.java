package com.chengziting.razor.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("test")
public class TestController {
    @RequestMapping("test1")
    public ModelAndView test1(){
        ModelAndView mv = new ModelAndView("/test/test1");
        return mv;
    }
}
