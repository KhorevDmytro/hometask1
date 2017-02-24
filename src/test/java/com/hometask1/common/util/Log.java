package com.hometask1.common.util;

import org.apache.log4j.Logger;

/**
 * Created by khd on 4/26/2016.
 */
public class Log {

    public static void Log(String msg) {
        Logger.getLogger(Log.class).info(msg);
    }

    public static void Error(String msg) {
        Logger.getLogger(Log.class).error(msg);
    }
}
