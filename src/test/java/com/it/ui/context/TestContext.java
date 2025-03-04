package com.it.ui.context;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import lombok.Data;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

@Data
public class TestContext {
    private String appPackage;
    private String deviceName;
    private String platform;
    private String automationName;
    private AppiumDriver driver;
    public TestContext(String appPackage, String deviceName, String platform, String automationName) {
        this.appPackage = appPackage;
        this.deviceName = deviceName;
        this.platform = platform;
        this.automationName = automationName;
    }
}
