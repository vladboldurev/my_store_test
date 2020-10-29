package com.mystore.pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;


public class ClothingCategoriesComponent extends BaseComponents{

    private WebDriver driver;

    @FindBy(xpath = "//a[@title='Women']/..")
    private WebElement womenCategoryButton;

    @FindBy(xpath = "//a[@title='Dresses']/..")
    private WebElement dressesCategoryButton;

    @FindBy(xpath = "//a[@title='T-shirts']/..")
    private WebElement tShirtsCategoryButton;

    public ClothingCategoriesComponent(WebDriver driver) {
        super(driver);
    }

    public boolean womenCategoryButtonIsVisible(){
        return
    }


}
