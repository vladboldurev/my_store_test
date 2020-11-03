package com.mystore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.junit.Assert.*;


public class MainPage extends BasePage {

    @FindBy(xpath = "//a[@title='Women']/..")
    private WebElement womenClothesButton;

    private static final String url = "http://automationpractice.com/index.php";
    private static final String title = "My Store";

    @Override
    public void load(){
        driver.get(url);
    }

    @Override
    public void isLoaded(){
        assertEquals(title, driver.getTitle());
    }

    public  MainPage open(){
        get();
        return this;
    }

    public boolean womenClothesButtonIsVisible(){
        return isVisible(womenClothesButton);
    }

    public WomenClothesPage clickOnWomenClothesButton(){
        wait.forElementVisible(womenClothesButton);
        wait.forElementClickable(womenClothesButton);
        womenClothesButton.click();
        return new WomenClothesPage();
    }


}
