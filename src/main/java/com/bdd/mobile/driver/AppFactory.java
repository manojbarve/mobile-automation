package com.bdd.mobile.driver;
/*
 * This class help to launch the android or ios app based on the platform set
 */

import com.bdd.mobile.base.AppData;
import com.bdd.mobile.base.Utility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.SkipException;

import java.net.MalformedURLException;
import java.net.URL;

public class AppFactory {
    static AppiumDriver driver;
    private static final String aos_deviceName = Utility.getConfigPropertyVal("aos.deviceName");
    private static final String aos_devicePlatformVersion = Utility.getConfigPropertyVal("aos.devicePlatformVersion");

    private static final String appiumServerUrl = Utility.getConfigPropertyVal("appiumServerUrl");

    private static final String ios_deviceName = Utility.getConfigPropertyVal("ios.deviceName");
    private static final String ios_devicePlatformVersion = Utility.getConfigPropertyVal("ios.devicePlatformVersion");
    private static final String ios_mydemoapp_bundleId = Utility.getConfigPropertyVal("ios.mydemoapp.bundleid");

    private static void android_launchApp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(aos_deviceName)
                .setPlatformVersion(aos_devicePlatformVersion)
                .setApp(System.getProperty("user.dir") + "\\src\\test\\resources\\apps\\Android-MyDemoAppRN.1.3.0.build-244.apk")
                .setAppActivity(".MainActivity")
                .setFullReset(false);

        driver = new AndroidDriver(new URL(appiumServerUrl), options);
        AppDriver.setDriver(driver);
        System.out.println("AndroidDriver is set");
    }

    //make sure the mydemo app is already installed in the device to use the bundle id. otherwise please use .setApp(APP path) to install app at runtime in the device.
    private static void ios_launchApp() throws MalformedURLException, MalformedURLException {
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName(ios_deviceName)
                .setPlatformVersion(ios_devicePlatformVersion)
                .setBundleId(ios_mydemoapp_bundleId)
                .setFullReset(false);

        driver = new IOSDriver(new URL(appiumServerUrl), options);
        AppDriver.setDriver(driver);
        System.out.println("IOSDriver is set");
    }
    
    public static void launchApp() throws MalformedURLException {
        System.out.println("entering into launchapp");
        if (AppData.platform.contains("ios")) {
            ios_launchApp();
        } else if (AppData.platform.contains("android")) {
            android_launchApp();
            System.out.println("Android launched...");
        } else
            throw new SkipException("Enter valid platform value, android/ios");
    }


}
