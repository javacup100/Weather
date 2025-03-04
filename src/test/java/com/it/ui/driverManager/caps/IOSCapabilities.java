package com.it.ui.driverManager.caps;

import com.it.ui.context.TestContext;
import io.appium.java_client.ios.options.XCUITestOptions;

public class IOSCapabilities extends CommonCapabilities {

    public  XCUITestOptions getIosOptions(TestContext context) {
        XCUITestOptions iosOptions = new XCUITestOptions();

        iosOptions.setDeviceName(context.getDeviceName());
        iosOptions.setBundleId(context.getAppPackage());
        iosOptions.setAutoAcceptAlerts(true);
        iosOptions.merge(getOptions());
        return iosOptions;
    }
}

