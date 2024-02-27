package com.bdd.mobile.base;
/*
 *This class is base class to launch app, start or  appium server
 */

import com.bdd.mobile.driver.AppFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.net.MalformedURLException;

public class BaseTest {

    @BeforeAll
    public static void launchApp() throws MalformedURLException {
        System.out.println("Initiate app");
        AppFactory.launchApp();
    }

    @BeforeAll
    public static void serverStart() {
        System.out.println("Start Appium Server");
        AppiumServer.start();
        System.out.println("Appium Server Started");
    }

    @AfterAll
    public static void serverStop() {
        AppiumServer.stop();
    }
}
