package com.hometask1.pages.popups;

import com.hometask1.pages.PostNewAdPage;
import com.hometask1.pages._Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by KDAMAC on 24.02.17.
 */
public class LoginPopup extends _Page {

    @FindBy(css = ".login-page #userEmail")
    WebElement userEmail;

    @FindBy(css = ".login-page #userPass")
    WebElement userPass;

    @FindBy(css = ".login-page #se_userLogin")
    WebElement se_userLogin;


    @Step
    public LoginPopup enterEmail(String text) {
        userEmail.sendKeys(text);
        return this;
    }

    @Step
    public LoginPopup enterPassword(String text) {
        userPass.sendKeys(text);
        return this;
    }

    @Step
    public PostNewAdPage submitLogin() {
        se_userLogin.click();
        return new PostNewAdPage();
    }
}