package com.mystore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

import com.mystore.common.core.element.Wait;
import com.mystore.common.core.element.JavascriptActions;
import com.mystore.common.driverprovider.DriverProvider;

public abstract class BasePage extends LoadableComponent<BasePage> {

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


}
