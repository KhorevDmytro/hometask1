package com.hometask1.common.util;

import com.hometask1.common.session.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by khd on 4/26/2016.
 */
public class Waiter {

    private static final long WAIT_INTERVAL = 30;
    private static final long IMPLICIT_INTERVAL = 1000;
    private static final long POLLING_INTERVAL = 100;

    public static WebElement waitForVisible(WebElement element) {
        return wrappedWait(ExpectedConditions.visibilityOf(element));
    }

    public static void waitAjaxStop(long waitFor) {
        resetImplicitWait();
        waitImplicit();
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), WAIT_INTERVAL, POLLING_INTERVAL);
        try {

            wait.withTimeout(waitFor, TimeUnit.SECONDS).until((ExpectedCondition<Boolean>) _driver -> {
                JavascriptExecutor executor = (JavascriptExecutor) _driver;
                long active = (Long) executor.executeScript("return jQuery.active;");
                return (active == 0);
            });
        } catch(TimeoutException e) {
            JavascriptExecutor executor = DriverManager.getExecutor();
            executor.executeScript("jQuery.active=0;");
        }
        setImplicitWait();
    }

    public static void waitAjaxStop() {
        waitAjaxStop(WAIT_INTERVAL);
    }

    public static void waitImplicit(long interval) {
        try {
            Thread.sleep(interval);
        } catch (InterruptedException e) {
            Log.Log("Thread interrupted while waiting");
        }
    }

    public static void waitImplicit() {
        waitImplicit(IMPLICIT_INTERVAL);
    }

    @SuppressWarnings("unchecked")
    private static <V> V wrappedWait(ExpectedCondition expectedCondition) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), WAIT_INTERVAL, POLLING_INTERVAL);
        resetImplicitWait();
        V element = (V) wait.until(expectedCondition);
        setImplicitWait();
        return element;
    }


    private static void setImplicitWait() {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(IMPLICIT_INTERVAL, TimeUnit.MILLISECONDS);
    }

    private static void resetImplicitWait() {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }
}
