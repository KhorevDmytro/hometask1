package com.hometask1.common.session;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Created by khd on 4/26/2016.
 */
public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public static void init(WebDriver drv) {
        driver.set(drv);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static JavascriptExecutor getExecutor() {
        return (JavascriptExecutor) driver.get();
    }

    public static void open(String url) {
        driver.get().get(url);
    }

    public static void  close() {
        driver.get().quit();
    }
}
