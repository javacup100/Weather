package com.it.ui.pages;

import com.it.ui.utils.ElementFindder;
import com.it.utils.ConfigLoader;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class DisclaimerPage {
    private AppiumDriver driver;
    private ElementFindder elementFindder;
    private WebElement acceptButton;

    public DisclaimerPage(AppiumDriver driver) {
        this.driver = driver;
        elementFindder = new ElementFindder(driver);
        initialize();
    }
    private void initialize(){
        ConfigLoader configLoader=new ConfigLoader("testdata/ui/BeforeHomePage.properties");
        acceptButton=elementFindder.findById(configLoader.get("disclaimer.accept.button"));
    }

    public boolean isDisplayed() {
        return acceptButton.isDisplayed();
    }

    public void acceptDisclaimer() {
        try {
            acceptButton.click();
            TimeUnit.SECONDS.sleep(1);
            acceptButton.click();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

