package com.chengziting.razor.web.core;

import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Created by user on 2018-03-02.
 */
public class MyDispatcherServlet extends DispatcherServlet {
    @Override
    protected void initStrategies(ApplicationContext context) {
        System.out.println("DispatcherServlet->initStrategies");
        super.initStrategies(context);
    }
}
