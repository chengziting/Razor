package com.chengziting.razor.utils.common;

import org.apache.log4j.xml.DOMConfigurator;

import java.net.URL;

/**
 * Created by user on 2017-12-26.
 */
public class SystemLog {
    private static SystemLog instance;

    private SystemLog(){
        final URL url = SystemLog.class.getResource("log4j-config.xml");
        DOMConfigurator.configure(url);
    }

    private static synchronized void preInit(){
        if(instance == null){
            instance = new SystemLog();
        }
    }

    public static void logError(Exception ex){

    }
}
