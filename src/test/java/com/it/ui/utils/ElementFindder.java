package com.it.ui.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementFindder {
    private AppiumDriver driver;
    public ElementFindder(AppiumDriver driver) {
        this.driver = driver;
    }
    public WebElement findById(String locator) {
        try {
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
        } catch (NoSuchElementException e){
            e.printStackTrace();
            return null;
        }
    }
    public WebElement findByXpath(String locator) {
        try {
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        } catch (NoSuchElementException e){
            e.printStackTrace();
            return null;
        }
    }
}
