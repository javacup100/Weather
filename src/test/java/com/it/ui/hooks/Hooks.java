package com.it.ui.hooks;

import com.it.ui.context.TestContext;
import com.it.ui.driverManager.DriverFactory;
import com.it.ui.teststeps.BaseTest;
import com.it.utils.ConfigLoader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class Hooks {
    private static Properties properties = new Properties();
    private static TestContext testContext;
    public Hooks() {
        System.out.println("Loading properties from file..........");
    }
    @BeforeAll
    public static void setTestContext() {
        ConfigLoader configLoader=new ConfigLoader("test-context.properties");
        String appPackage=configLoader.get("appPackage");
        String deviceName=configLoader.get("deviceName");
        String platform=configLoader.get("platform");
        String automationName=configLoader.get("automationName");
        BaseTest.setTestContext(appPackage, deviceName, platform, automationName);
        testContext=BaseTest.getTestContext();
        testContext.setDriver(DriverFactory.createDriver(testContext));
    }

    @AfterAll
    public static void teardown() {
        if (testContext.getDriver() != null) {
            testContext.getDriver().quit();
        }
    }

    public static TestContext getTestContext() {
        return testContext;
    }
}

