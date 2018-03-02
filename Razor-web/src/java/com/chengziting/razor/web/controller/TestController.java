package com.chengziting.razor.web.controller;

import com.chengziting.razor.model.persistent.Roles;
import com.chengziting.razor.service.IRolesService;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("test")
public class TestController {
    @Autowired
    private IRolesService rolesService;
    private static Logger logger = Logger.getLogger(TestController.class);
    @RequestMapping("test1")
    public ModelAndView test1(){
        ModelAndView mv = new ModelAndView("/test/test1");
        Roles roles = rolesService.get("1000");
        logger.info(new Gson().toJson(roles));
        mv.addObject("data",roles);
        return mv;
    }
}
