package com.bdd.mobile.base;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;

/*
 * This class helps to create Appium server
 * start or stop function for the appium server
 *  */

public class AppiumServer {
    static AppiumDriverLocalService server;
    private static final String appiumIpAddress = Utility.getConfigPropertyVal("appiumIPaddress");
    private static final String appiumJSpath = Utility.getConfigPropertyVal("appiumJSpath");
    private static final String AppiumDriverExecutablePath = Utility.getConfigPropertyVal("appiumDriverExecutablePath");

    private static void setInstance() {

        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder
                .withIPAddress(appiumIpAddress)
                .usingPort(4723)
                .withAppiumJS(new File(appiumJSpath))
                .usingDriverExecutable(new File(AppiumDriverExecutablePath))
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withLogFile(new File("Appiumlog.txt"));

        if (AppData.useGesturePlugin.contains("true")) {
            builder.withArgument(GeneralServerFlag.USE_PLUGINS, "gestures");
        }

        if (AppData.chromeAutoDownloadDriver.contains("true")) {
            builder.withArgument(GeneralServerFlag.ALLOW_INSECURE, "chromedriver_autodownload");
        }

        server = AppiumDriverLocalService.buildService(builder);

    }

    private static AppiumDriverLocalService getInstance() {
        if (server == null) {
            setInstance();
        }
        return server;
    }

    public static void start() {
        getInstance().start();
        System.out.println(server.getUrl());
        System.out.println(server.isRunning());
    }

    public static void stop() {
        if (server != null) {
            getInstance().stop();
            System.out.println("Appium server stopped");
        }
    }
}
