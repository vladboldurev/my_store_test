package com.mystore.common.core.element;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavascriptActions {

        private final WebDriver driver;
        private final JavascriptExecutor js;

        public JavascriptActions(WebDriver driver){
            this.driver = driver;
            this.js = (JavascriptExecutor) driver;
        }

}
