package com.mystore.testcases;

import com.mystore.pages.WomenClothesPage;
import org.junit.Test;
import org.junit.Assert;

import com.mystore.pages.MainPage;

public class MainPageTest {

    @Test
    public void testSwitchCategoryClothes(){
        MainPage mainPage = new MainPage().open();
        Assert.assertTrue(mainPage.womenClothesButtonIsVisible());
        WomenClothesPage womenClothesPage = mainPage.clickOnWomenClothesButton();
        Assert.assertTrue(womenClothesPage.womenCategoryNameSpanIsVisible());
    }

}
