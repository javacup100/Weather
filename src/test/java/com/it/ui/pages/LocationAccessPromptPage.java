package com.it.ui.pages;

import com.it.ui.utils.ElementFindder;
import com.it.utils.ConfigLoader;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class LocationAccessPromptPage {
    private AppiumDriver driver;
    private ElementFindder elementFindder;
    private WebElement title;
    private WebElement closeButton;

    public LocationAccessPromptPage(AppiumDriver driver) {
        this.driver = driver;
        this.elementFindder = new ElementFindder(driver);
        initialize();
    }
    private void initialize(){
        ConfigLoader configLoader=new ConfigLoader("testdata/ui/BeforeHomePage.properties");
        title=elementFindder.findById(configLoader.get("location.access.title"));
        closeButton=elementFindder.findById(configLoader.get("location.access.button"));
    }

    public boolean isDisplayed() {
        return title.isDisplayed();
    }

    public void close() {
            closeButton.click();
    }
}

