package com.hometask1.dataprovider;

import com.hometask1.dataprovider.model.Advert;
import org.testng.annotations.DataProvider;

/**
 * Created by khd on 4/26/2016.
 */
public class PostDataProvider {

    @DataProvider
    public  static Object[][] dataProvider() {
        Advert advert = new Advert();
        advert.category = "Дом и сад";
        advert.subCategory = "Сад / огород";
        advert.title = "Tree from forest";
        advert.price = "100";
        advert.business = "Частное лицо";
        advert.description = "Green Tree blablablablablabla";
        advert.address = "Киев, Киевская область";
        advert.contactPerson = "Someone";
        advert.email = "just123fortest@gmail.com";
        advert.password = "zxcLKJqwe098";

        return new Advert[][]{{advert}};
    }
}
