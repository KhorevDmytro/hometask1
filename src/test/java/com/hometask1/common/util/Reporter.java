package com.hometask1.common.util;

import com.hometask1.common.session.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by khd on 4/26/2016.
 */
public class Reporter {

    @Attachment(value = "{0}", type = "image/png")
    public static byte[] reportScreenshot(String name) {
        Waiter.waitImplicit();
        try {
            return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
        } catch (RuntimeException e) {
            return new byte[]{0};
        }
    }

    @Attachment(value = "{0}", type = "image/png")
    public static byte[] reportScreenshot(String name, Boolean quick) {
        if (!quick) {
            Waiter.waitImplicit();
        }
        try {
            return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
        } catch (RuntimeException e) {
            return new byte[]{0};
        }
    }

    @Attachment(value = "{0}", type = "image/png")
    public static byte[] reportErrorScreenshot(String name) {
        try {
            return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
        } catch (RuntimeException e) {
            return new byte[]{0};
        }
    }

    @Step("{0}")
    public static void report(String text) {}

}
