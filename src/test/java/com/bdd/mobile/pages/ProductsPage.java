package com.bdd.mobile.pages;

/*
 * This class is the page factory for products page
 */

import com.bdd.mobile.driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class ProductsPage extends BasePage {
    By productPageheader = AppiumBy.accessibilityId("container header");
    private By last_item;

    public ProductsPage() {
        if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
            last_item = AppiumBy.xpath("//*[@text='Test.allTheThings() T-Shirt']");
        } else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {
            last_item = AppiumBy.xpath("//XCUIElementTypeOther[@name=\"Test.allTheThings() T-Shirt\"]");
        }
    }

    public boolean waitForProductText() {
        return waitForEl(productPageheader).isDisplayed();
    }

    public void selectLastProduct() {
        waitNclick(last_item);
    }


}
