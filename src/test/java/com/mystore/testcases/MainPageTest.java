package com.mystore.testcases;

import org.junit.Test;

import com.mystore.pages.MainPage;

public class MainPageTest {

    @Test
    public void testSwitchCategoryClothes(){
        MainPage mainPage = new MainPage().open();
        mainPage.clickOnWomenClothesButton();
    }

}
