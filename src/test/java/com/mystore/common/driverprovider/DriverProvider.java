package com.mystore.common.driverprovider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverProvider {

    private static WebDriver driver = new ChromeDriver();

    public static WebDriver getDriver() { return driver; }

}
