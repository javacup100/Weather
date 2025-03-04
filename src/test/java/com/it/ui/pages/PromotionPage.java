package com.it.ui.pages;

import com.it.ui.utils.ElementFindder;
import com.it.utils.ConfigLoader;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class PromotionPage {
    private AppiumDriver driver;
    ElementFindder elementFindder;
    private WebElement title;
    private WebElement nextButton;

    public PromotionPage(AppiumDriver driver) {
        this.driver = driver;
        this.elementFindder = new ElementFindder(driver);
        initialize();
    }

    private void initialize() {
        ConfigLoader configLoader = new ConfigLoader("testdata/ui/BeforeHomePage.properties");
        title = elementFindder.findByXpath(configLoader.get("promotion.id"));
        nextButton = elementFindder.findById(configLoader.get("promotion.next.button"));
    }

    public boolean isDisplayed() {
        return title.isDisplayed();
    }

    public void close() {
        try {
            nextButton.click();
            TimeUnit.SECONDS.sleep(2);
            nextButton.click();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

