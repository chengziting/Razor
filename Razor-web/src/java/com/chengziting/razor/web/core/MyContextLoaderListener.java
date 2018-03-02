package com.chengziting.razor.web.core;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

/**
 * Created by user on 2018-03-02.
 */
public class MyContextLoaderListener extends ContextLoaderListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("ContextLoaderListener->contextInitialized");
        super.contextInitialized(event);
    }

    @Override
    public WebApplicationContext initWebApplicationContext(ServletContext servletContext) {
        System.out.println("ContextLoaderListener->initWebApplicationContext");
        return super.initWebApplicationContext(servletContext);
    }
}
