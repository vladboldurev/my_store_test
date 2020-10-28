package com.mystore.testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mystore.pages.MainPage;

public class MainPageTest {

    @Test
    public void testSwitchCategoryClothes(){
        MainPage mainPage = new MainPage().open();
    }

}
