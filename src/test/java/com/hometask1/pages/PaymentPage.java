package com.hometask1.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by KDAMAC on 24.02.17.
 */
public class PaymentPage extends _Page {

    @FindBy(css = ".successbox>p")
    WebElement successbox;

    public String isSuccessMessageShown() {
        return successbox.getText();
    }
}