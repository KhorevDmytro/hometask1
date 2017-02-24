package com.hometask1.pages.popups;

import com.hometask1.pages.PostNewAdPage;
import com.hometask1.pages._Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static com.hometask1.common.util.Waiter.waitAjaxStop;

/**
 * Created by KDAMAC on 24.02.17.
 */
public class SelectCategoryPopup extends _Page {

    @FindBy(id = "icons-placeholder")
    WebElement category;

    @FindBy(css = ".selected.icon-list-main")
    WebElement mainCategory;


    @Step
    public SelectCategoryPopup selectCategory(String text) {
        List<WebElement> options = category.findElements(By.cssSelector("[data-category-name]"));
        for (WebElement option : options) {
            if (option.getAttribute("data-category-name").equals(text)){
                option.click();
                break;
            }
        }
        return this;
    }

    @Step
    public PostNewAdPage selectSubCategory(String text) {
        String dataCategory = mainCategory.getAttribute("data-category");
        List<WebElement> options = driver.findElement(By.id("category-"+dataCategory)).findElements(By.tagName("a"));
        for (WebElement option : options) {
            if (option.getAttribute("innerText").equals(text)) {
                option.click();
                break;
            }
        }
        waitAjaxStop();
        return new PostNewAdPage();
    }
}