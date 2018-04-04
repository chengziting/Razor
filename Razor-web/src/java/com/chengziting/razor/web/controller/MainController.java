package com.chengziting.razor.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by user on 2018-02-24.
 */
@Controller
@RequestMapping("main")
public class MainController {

    @RequestMapping("home")
    public ModelAndView home(){

        ModelAndView mv = new ModelAndView("/main/home");
        return mv;
    }
}
