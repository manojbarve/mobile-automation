package com.bdd.mobile.testRunner;
/*
 * This class help to run the test cases
 * Junit test execution class
 * Plugins for generating test reports after test execution.
 */

import com.bdd.mobile.base.AppiumServer;
import com.bdd.mobile.driver.AppFactory;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.net.MalformedURLException;

import static com.bdd.mobile.base.BaseTest.serverStart;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com/bdd/mobile/steps"},
        tags = "@login",
        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html",
                "json:target/CucumberTestReport.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        stepNotifications = true,
        monochrome = true)

public class TestRunner {

    @BeforeClass
    public static void startSetUp() throws MalformedURLException {
        System.out.println("start the server");
        serverStart();
        AppFactory.launchApp();
    }

    @AfterClass
    public static void stopServer() {
        AppiumServer.stop();
        System.out.println("Appium server stopped");

    }

}
