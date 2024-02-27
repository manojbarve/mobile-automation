package com.bdd.mobile.pages;
/*
 * This class is the page factory for product details page
 */

import com.bdd.mobile.driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class ProductsDetailsPage extends BasePage {
    By productPageDetailsheader = AppiumBy.accessibilityId("container header");

    public ProductsDetailsPage() {
        if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
            productPageDetailsheader = AppiumBy.xpath("//*[@text='Test.allTheThings() T-Shirt']");
        } else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {
            productPageDetailsheader = AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Test.allTheThings() T-Shirt']");
        }
    }

    public boolean waitForProductDetailsText() throws InterruptedException {
        waitForEl(productPageDetailsheader);
        return waitForEl(productPageDetailsheader).isDisplayed();
    }

}
