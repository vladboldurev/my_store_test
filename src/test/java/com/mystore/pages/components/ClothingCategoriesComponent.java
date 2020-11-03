package com.mystore.pages.components;

import com.mystore.pages.WomenClothesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mystore.pages.BasePage;

//TODO наследовтаь от BasePage
public class ClothingCategoriesComponent extends BasePage{

    private WebDriver driver;

    @FindBy(xpath = "//a[@title='Women']/..")
    private WebElement womenCategoryButton;

    @FindBy(xpath = "//a[@title='Dresses']/..")
    private WebElement dressesCategoryButton;

    @FindBy(xpath = "//a[@title='T-shirts']/..")
    private WebElement tShirtsCategoryButton;

    public boolean womenCategoryButtonIsVisible(){
        return isVisible(womenCategoryButton);
    }

    public boolean dressesCategoryButtonIsVisible(){
        return isVisible(dressesCategoryButton);
    }

    public boolean tShirtsCategoryButtonIsVisible(){
        return isVisible(tShirtsCategoryButton);
    }

    public WomenClothesPage womenClothesPageClick(){
        wait.forElementVisible(womenCategoryButton);
        wait.forElementClickable(womenCategoryButton);
        womenCategoryButton.click();
        WomenClothesPage womenClothesPage = new WomenClothesPage();
        womenClothesPage.waitForPageLoad();
        return womenClothesPage;
    }





}
