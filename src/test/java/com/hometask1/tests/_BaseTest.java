package com.hometask1.tests;

import com.hometask1.common.session.Browser;
import com.hometask1.common.session.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import org.testng.xml.XmlTest;

import java.util.Map;

/**
 * Created by khd on 4/26/2016.
 */
public class _BaseTest {

    SoftAssert softAssert = new SoftAssert();

    @BeforeTest
    public void initTest(XmlTest xmlTest) {
        Map<String,String> testParams = xmlTest.getAllParameters();

        Browser browser = new Browser(
                testParams.getOrDefault("browser", "chrome"));

        WebDriver driver = browser.build();
        DriverManager.init(driver);
    }

    @AfterTest
    public void afterTest() {
        DriverManager.close();
    }
}
