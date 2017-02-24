package com.hometask1.tests;

import com.hometask1.dataprovider.PostDataProvider;
import com.hometask1.dataprovider.model.Advert;
import com.hometask1.pages.HomePage;
import com.hometask1.pages.PaymentPage;
import com.hometask1.pages.PostNewAdPage;
import com.hometask1.pages.popups.LoginPopup;
import com.hometask1.pages.popups.SelectCategoryPopup;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

/**
 * Created by KDAMAC on 24.02.17.
 */
public class LoginTest extends _BaseTest {

    private HomePage homePage;

    @Test(dataProviderClass = PostDataProvider.class, dataProvider = "dataProvider")
    @Features("Test OLX")
    @Stories("Login to OLX")
    @Description("Verify that user can login to olx")
    public void AdvertCreation(Advert advert) {

        homePage
                .clickAddPost();

        LoginPopup loginPopup = new LoginPopup();
        loginPopup
                .enterEmail(advert.email)
                .enterPassword(advert.password)
                .submitLogin();

        PostNewAdPage postNewAdPage = new PostNewAdPage();
        postNewAdPage
                .openPopupToSelectCategory();

        SelectCategoryPopup selectCategoryPopup = new SelectCategoryPopup();
        selectCategoryPopup
                .selectCategory(advert.category)
                .selectSubCategory(advert.subCategory);

        PostNewAdPage postNewAdPage2 = new PostNewAdPage();
        postNewAdPage2
                .enterTitle(advert.title)
                .enterPrice(advert.price)
                .selectBusiness(advert.business)
                .enterDescription(advert.description)
                .enterAddress(advert.address)
                .enterContactPerson(advert.contactPerson)
                .submitPost();

        Assert.assertEquals(new PaymentPage().isSuccessMessageShown(), "Ваше объявление принято!");
    }

    @BeforeClass
    public void initPages() {

        homePage = new HomePage(true);
    }

//    @AfterMethod
//    public void deletePost(){
//
//    }
}
