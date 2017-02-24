package com.hometask1.pages;

import com.hometask1.common.session.DriverManager;
import com.hometask1.pages.popups.SelectCategoryPopup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static com.hometask1.common.util.Waiter.waitAjaxStop;
import static com.hometask1.common.util.Waiter.waitForVisible;

/**
 * Created by KDAMAC on 24.02.17.
 */
public class PostNewAdPage extends _Page {

    @FindBy(id = "add-title")
    WebElement addTitle;

    @FindBy(id = "targetrenderSelect1-0")
    WebElement target;

    @FindBy(id = "add-description")
    WebElement addDescription;

    @FindBy(id = "mapAddress")
    WebElement mapAddress;

    @FindBy(id = "add-person")
    WebElement addPerson;

    @FindBy(css = "[name='data[param_price][1]']")
    WebElement price;

    @FindBy(id = "targetid_private_business")
    WebElement private_business;

    @FindBy(css = ".submitspace")
    WebElement submitPost;

    @Step
    public PostNewAdPage enterTitle(String text) {
        addTitle.sendKeys(text);
        return this;
    }

    @Step
    public SelectCategoryPopup openPopupToSelectCategory() {
        waitForVisible(target);
        target.click();
        waitAjaxStop();
        return new SelectCategoryPopup();
    }

    @Step
    public PostNewAdPage enterDescription(String text) {
        addDescription.sendKeys(text);
        return this;
    }

    @Step
    public PostNewAdPage enterAddress(String text) {
        mapAddress.clear();
        mapAddress.sendKeys(text);
        WebElement autosuggest = driver.findElement(By.id("autosuggest-geo-ul"));
        waitAjaxStop(1);
        List<WebElement> options = autosuggest.findElements(By.tagName("a"));
        for (WebElement option : options) {
            if(option.getAttribute("innerText").equals(text)){
                option.click();
                break;
            }
        }
        return this;
    }

    @Step
    public PostNewAdPage enterContactPerson(String text) {
        if (addPerson.isEnabled()){
            addPerson.sendKeys(text);
        }
        return this;
    }

    @Step
    public PostNewAdPage enterPrice(String text) {
        price.sendKeys(text);
        return this;
    }

    @Step
    public PostNewAdPage selectBusiness(String text) {
        private_business.findElement(By.tagName("a")).click();
        List<WebElement> options = private_business.findElement(By.tagName("ul")).findElements(By.tagName("a"));
        for (WebElement option : options) {
            if (option.getAttribute("innerText").contains(text)) {
                option.click();
            }
        }
        return this;
    }

    @Step
    public void submitPost() {
        DriverManager.getExecutor().executeScript("arguments[0].scrollIntoView(true);", submitPost);
        submitPost.click();
    }
}