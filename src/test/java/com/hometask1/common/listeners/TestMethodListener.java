package com.hometask1.common.listeners;

import org.openqa.selenium.UnhandledAlertException;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import static com.hometask1.common.util.Log.Log;
import static com.hometask1.common.util.Reporter.reportErrorScreenshot;

/**
 * Created by khd on 4/26/2016.
 */
public class TestMethodListener implements IInvokedMethodListener{

    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
    }

    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        String text = "";

        Boolean success = iTestResult.isSuccess();
        if (!success) {
            if (iTestResult.getThrowable() instanceof UnhandledAlertException) {
                AssertionError error = new AssertionError("Unexpected alert open. Alert text: " + text);
                iTestResult.setThrowable(error);
            } else {
                reportErrorScreenshot("Error");
            }
        }

        if (iInvokedMethod.isTestMethod()) {
            Log(logEntry(iInvokedMethod, iTestResult));
        }
    }

    private String getResult(int status) {

        String result = "Start - ";

        if (status == 1) result = "Pass -- ";
        else if (status == 2) result = "Fail! - ";
        else if (status == 3) result = "Skip -- ";

        return result;
    }

    private String logEntry(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

        String testClass = iTestResult.getTestClass().getRealClass().getSimpleName();
        String method = iInvokedMethod.getTestMethod().getMethodName();

        return getResult(iTestResult.getStatus()) + testClass + "." + method;
    }

}
