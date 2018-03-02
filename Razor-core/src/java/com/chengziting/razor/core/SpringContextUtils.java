package com.chengziting.razor.core;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.orm.hibernate5.HibernateTemplate;

/**
 * Created by user on 2018-02-26.
 */
public class SpringContextUtils implements ApplicationContextAware {
    private static ApplicationContext context;

    public SpringContextUtils(){
        System.out.println("init SpringContextUtils.");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static ApplicationContext getContext(){
        return context;
    }

    public static Session getCurrentSession(){
        SessionFactory factory = context.getBean(SessionFactory.class);
        if(factory != null){
            return factory.getCurrentSession();
        }
        return null;
    }
}
