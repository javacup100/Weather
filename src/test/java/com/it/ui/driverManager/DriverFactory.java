package com.it.ui.driverManager;

import com.it.ui.context.TestContext;
import com.it.ui.driverManager.caps.AndroidCapabilities;
import com.it.ui.driverManager.caps.IOSCapabilities;
import com.it.utils.ConfigLoader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {
    private static AppiumDriver driver;

    public static AppiumDriver createDriver(TestContext context) {
        ConfigLoader configLoader=new ConfigLoader("testdata/ui/base.properties");
        String appiumServer=configLoader.get("appium.server");
        try {
            if (context.getPlatform().equals("Android")) {
                AndroidCapabilities caps = new AndroidCapabilities();
                driver = new AndroidDriver(new URL(appiumServer), caps.getAndroidOptions(context));
                System.out.println("driver created......");
            } else if (context.getPlatform().equals("iOS")) {
                IOSCapabilities caps = new IOSCapabilities();
                driver = new IOSDriver(new URL(appiumServer), caps.getIosOptions(context));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}

