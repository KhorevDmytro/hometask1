package com.hometask1.common.session;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by khd on 4/25/2016.
 */
public class Browser {

    private String browser;
    private String userDir;

    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";

    public Browser(String browser) {
        this.browser = browser;
    }

    public WebDriver build() {
        DesiredCapabilities capabilities;

        if (FIREFOX.equals(browser)) {
            capabilities = DesiredCapabilities.firefox();
            return new FirefoxDriver(capabilities);
        }

        capabilities = DesiredCapabilities.chrome();
        Map<String,String> prefs = new HashMap<>();
        prefs.put("download.prompt_for_download", "false");
        prefs.put("download.default_directory", userDir);

        ChromeOptions options = new ChromeOptions();

        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--test-type");
        options.addArguments("start-maximized");

        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        return new ChromeDriver(capabilities);
    }
}
