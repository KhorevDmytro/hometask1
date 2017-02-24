package com.hometask1.pages;

import com.hometask1.common.session.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.hometask1.common.util.Waiter.waitAjaxStop;

/**
 * Created by khd on 4/26/2016.
 */
public class _Page {

    protected WebDriver driver;
    protected String pageURL;

    public _Page() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    public _Page(String pageURL) {
        this();
        this.pageURL = pageURL;
    }

    public _Page(String pageURL, boolean doOpen) {
        this(pageURL);
        if (doOpen) reOpen();
    }

    public void reOpen() {
        driver.get(pageURL);
    }

    public void open(String url) {
        this.pageURL = url;
        reOpen();
    }
}
