package com.mystore.pages;

import com.mystore.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class WomenClothesPage extends BasePage  {
    private static final String PAGE_ID = "//span[@class='category-name' and contains(text(), 'Women')]";

    @FindBy(xpath=PAGE_ID)
    public WebElement womenCategoryNameSpan;

    public boolean womenCategoryNameSpanIsVisible(){
        return isVisible(womenCategoryNameSpan);
    }

    public void waitForPageLoad(){
        waitForPageLoad(By.xpath(PAGE_ID));
    }

}
