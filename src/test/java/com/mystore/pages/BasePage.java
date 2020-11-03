package com.mystore.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.mystore.common.core.element.Wait;
import com.mystore.common.core.element.JavascriptActions;
import com.mystore.common.driverprovider.DriverProvider;

public class BasePage extends LoadableComponent<BasePage> {

    protected Wait wait;
    protected Actions builder;
    protected WebDriver driver = DriverProvider.getDriver();
    protected JavascriptActions jsActions;

    public BasePage() {
        this.wait = new Wait(driver);
        this.builder = new Actions(driver);
        this.jsActions = new JavascriptActions(driver);

        PageFactory.initElements(driver, this);
    }

    @Override
    public void load(){}

    @Override
    public void isLoaded() throws Error {}

    public boolean isVisible(WebElement element) {
        try {
            wait.forElementVisible(element);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void waitAndClick(WebElement webElement){
        wait.forElementClickable(webElement).click();
    }

    public void waitAndFillInput(WebElement webElement, String value){
        wait.forElementVisible(webElement).sendKeys(value);
    }

    public void waitForPageLoad(By by){
        wait.forElementPresent(by);
    }

}
