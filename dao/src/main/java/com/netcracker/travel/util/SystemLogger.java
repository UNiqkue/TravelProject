package com.netcracker.travel.util;

import org.apache.log4j.Logger;

public class SystemLogger {
    private Logger logger;
    private static SystemLogger instance;

    private SystemLogger(){}

    public static synchronized SystemLogger getInstance(){
        if(instance == null){
            instance = new SystemLogger();
        }
        return instance;
    }

    public void logError(Class sender, String message){
        logger = Logger.getLogger(sender);
        logger.error(message);
    }


}