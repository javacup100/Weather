package com.it.ui.driverManager.caps;

import com.it.ui.context.TestContext;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AndroidCapabilities extends CommonCapabilities {

    public UiAutomator2Options getAndroidOptions(TestContext context) {
        UiAutomator2Options androidOptions = new UiAutomator2Options();
        androidOptions.setDeviceName(context.getDeviceName());
        androidOptions.setAppPackage(context.getAppPackage());
        androidOptions.setAutoGrantPermissions(true);
        androidOptions.merge(getOptions());
        return androidOptions;
    }
}

