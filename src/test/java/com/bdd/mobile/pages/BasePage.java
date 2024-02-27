package com.bdd.mobile.pages;

/*
 * This class is the base class for the page classes.
 * Helper or utils class for the page classes
 */

import com.bdd.mobile.driver.AppDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getCurrentDriver()), this);
    }

    WebDriverWait wait = new WebDriverWait(AppDriver.getCurrentDriver(), Duration.ofSeconds(30));

    protected WebElement waitForEl(By byLocator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(byLocator));
    }

    protected WebElement getEl(By byLocator) {
        return AppDriver.getCurrentDriver().findElement(byLocator);
    }

    protected void click(By byLocator) {
        getEl(byLocator).click();
    }

    protected void waitNtype(By byLocator, String text) {
        waitForEl(byLocator);
        getEl(byLocator).clear();
        getEl(byLocator).sendKeys(text);
    }

    protected void waitNclick(By byLocator) {
        waitForEl(byLocator).click();
    }

    protected String getText(By byLocator) {
        String str = "";
        if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
            str = getEl(byLocator).getText();
        } else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {
            str = getAttribute(byLocator, "value");
        }
        return str;
    }

    protected String getAttribute(By byLocator, String attr) {
        return waitForEl(byLocator).getAttribute(attr);
    }
}
