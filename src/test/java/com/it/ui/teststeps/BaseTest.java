package com.it.ui.teststeps;

import com.it.ui.context.TestContext;

import java.util.Set;

public class BaseTest {
    private static TestContext testContext;
    public static TestContext getTestContext() {
        return testContext;
    }
    public static void setTestContext(String appPackage, String deviceName, String platform, String automationName){
        testContext = new TestContext(appPackage, deviceName, platform, automationName);
    }
}
