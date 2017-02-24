package com.hometask1.pages;

import com.hometask1.common.util.UrlLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static com.hometask1.common.util.Waiter.waitAjaxStop;

/**
 * Created by KDAMAC on 24.02.17.
 */
public class HomePage extends _Page{

    public HomePage() {
        this(true);
    }

    public HomePage(boolean open) {
        super(UrlLocator.BASE_URL, open);
    }

    @FindBy(id = "postNewAdLink")
    WebElement postNewAdLink;

    @Step
    public void clickAddPost() {
        postNewAdLink.click();
        waitAjaxStop();
    }

}