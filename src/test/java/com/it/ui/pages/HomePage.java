//package com.it.pages;
//
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.pagefactory.AppiumFieldDecorator;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import java.time.Duration;
//
//public class HomePage {
//    private AppiumDriver driver;
//    private By searchBox = By.id("search");
//    public boolean isDisplayed() {
//        return driver.findElement(someElement).isDisplayed();  // Replace with an element that is always present on the homepage
//    }
//    public HomePage(AppiumDriver driver) {
//        System.out.println("this in home page.............");
//        this.driver = driver;
//    }
//    @FindBy (id = "view_speak_stub")
//    private WebElement welcomeMessage;
//
//    public String getWelcomeMessage() {
//        System.out.println("accessible: "+welcomeMessage.getAccessibleName());
//        String content = welcomeMessage.getAttribute("content-desc");
//        System.out.println("content: "+content);
//        return content;
//    }
//    public void clickWelcome() {
//        welcomeMessage.click();
//    }
//}
//
