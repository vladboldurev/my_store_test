package com.mystore.common.core.element;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Wait {
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(15);
    private static final Duration DEFAULT_SLEEP = Duration.ofMillis(5000);
    private static final String INIT_MESSAGE = "INIT MESSAGE";
    private static final String INIT_ERROR_MESSAGE = "PROBLEM WITH ELEMENT INIT";
    private static final String ELEMENT_PRESENT_MESSAGE = "ELEMENT PRESENT";
    private static final String ELEMENT_PRESENT_ERROR_FORMAT = "PROBLEM WITH FINDING ELEMENT %s";

    private WebDriverWait wait;
    private WebDriverWait sleepingWait;
    private WebDriver driver;

    public Wait(WebDriver webDriver){
        this.driver = webDriver;
        this.wait = new WebDriverWait(webDriver, DEFAULT_TIMEOUT);
        this.sleepingWait = new WebDriverWait(webDriver, DEFAULT_TIMEOUT, DEFAULT_SLEEP);
    }

    public WebElement forElementPresent(By by) {
        return forElementPresent(by, true);
    }

    public WebElement forElementPresent(By by, boolean failOnTimeout){
        changeImplicitWait(250, TimeUnit.MILLISECONDS);
        try{
            return wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (TimeoutException e){
//          TODO log
            throw e;
        } finally {
            restoreDefaultImplicitWait();
        }
    }

    public WebElement forElementPresent(By by, int timeout){
        changeImplicitWait( 250, TimeUnit.MILLISECONDS);
        try{
            return new WebDriverWait(driver, Duration.ofSeconds(timeout)
            ).until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (TimeoutException e){
//          TODO log
            throw e;
        } finally {
            restoreDefaultImplicitWait();
        }
    }

    public WebElement forElementVisible(WebElement element){
        changeImplicitWait(0, TimeUnit.MILLISECONDS);
        try {
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e){
            throw e;
        } finally {
            restoreDefaultImplicitWait();
        }
    }

    public WebElement forElementVisible(WebElement element, int timeout, int polling){
        changeImplicitWait( 250, TimeUnit.MILLISECONDS);
        try{
            return new WebDriverWait(driver, Duration.ofSeconds(timeout),  Duration.ofSeconds(polling)
            ).until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e){
            throw e;
        } finally {
            restoreDefaultImplicitWait();
        }
    }

    public WebElement forElementVisible(WebElement element, int timeout){
        return forElementVisible(element, timeout, 500);
    }

    public WebElement forElementVisible(By by){
        changeImplicitWait( 250, TimeUnit.MILLISECONDS);
        try{
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (TimeoutException e){
            throw e;
        } finally {
            restoreDefaultImplicitWait();
        }
    }

    public WebElement forElementVisible(By by, int timeout, int polling){
        changeImplicitWait( 250, TimeUnit.MILLISECONDS);
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(timeout), Duration.ofSeconds(polling)
            ).until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (TimeoutException e){
            throw e;
        } finally {
            restoreDefaultImplicitWait();
        }
    }

    public WebElement forElementVisible(By by, int timeout){
        return forElementVisible(by, timeout, 500);
    }

    /**
     * Checks if the element is clickable in browser
     */

    public WebElement forElementClickable(WebElement element){
        changeImplicitWait( 250, TimeUnit.MILLISECONDS);
        try{
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e){
            throw e;
        } finally {
            restoreDefaultImplicitWait();
        }
    }

    public WebElement forElementClickable(WebElement element, int timeout){
        changeImplicitWait( 250, TimeUnit.MILLISECONDS);
        try{
            return new WebDriverWait(driver, Duration.ofSeconds(timeout)
            ).until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e){
            throw e;
        } finally {
            restoreDefaultImplicitWait();
        }
    }

    public WebElement forElementClickable(By by) {
        changeImplicitWait(250, TimeUnit.MILLISECONDS);
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(by));
        } finally {
            restoreDefaultImplicitWait();
        }
    }

    public WebElement forElementClickable(By by, int timeout) {
        changeImplicitWait(250, TimeUnit.MILLISECONDS);
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(timeout)
            ).until(ExpectedConditions.elementToBeClickable(by));
        } finally {
            restoreDefaultImplicitWait();
        }
    }

    private void restoreDefaultImplicitWait(){
        changeImplicitWait(DEFAULT_TIMEOUT.getSeconds(), TimeUnit.SECONDS);
    }

    private void changeImplicitWait(long value, TimeUnit timeUnit){
        driver.manage().timeouts().implicitlyWait(value, timeUnit);
    }







}
