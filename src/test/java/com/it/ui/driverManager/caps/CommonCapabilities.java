package com.it.ui.driverManager.caps;

import com.it.ui.context.TestContext;
import io.appium.java_client.remote.options.BaseOptions;

public class CommonCapabilities {

    private BaseOptions<?> options;

    public CommonCapabilities() {
        options = new BaseOptions<>();
    }

    public void setCommonCapabilities(TestContext context) {
        String platform = context.getPlatform();
        options.setPlatformName(platform);
        options.setAutomationName(platform.equals("Android") ? "UiAutomator2" : "XCUITest");
        options.setNoReset(true);
    }

    public BaseOptions<?> getOptions() {
        return options;
    }
}

