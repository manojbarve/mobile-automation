package com.bdd.mobile.pages;
/*
 * This class is the page factory for login page
 */

import com.bdd.mobile.driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private By userName;

    private By credentialsErrorText;

    private By loginPageTitleText;

    public LoginPage() {
        if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
            userName = AppiumBy.xpath("//*[@content-desc='Username input field']");
            loginPageTitleText = AppiumBy.xpath(("//*[@text='Login']"));
            credentialsErrorText = AppiumBy.xpath(("//*[@text='Provided credentials do not match any user in this service.']"));
        } else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {
            userName = AppiumBy.accessibilityId("Username input field");
            loginPageTitleText = By.xpath("//XCUIElementTypeStaticText[@name=\"Login\"]");
            credentialsErrorText = By.xpath("//XCUIElementTypeOther[@name='generic-error-message']/XCUIElementTypeStaticText");
        }
    }

    @AndroidFindBy(xpath = "//*[@content-desc='Password input field']")
    @iOSXCUITFindBy(accessibility = "Password input field")
    private WebElement Password;

    @AndroidFindBy(xpath = "//*[@content-desc='Login button']")
    @iOSXCUITFindBy(accessibility = "Login button")
    private WebElement btnLogin;

    public void login(String username, String password) {
        waitNtype(userName, username);
        Password.clear();
        Password.sendKeys(password);
        btnLogin.click();
    }

    public String getCredentialsErrorText() {
        return getText(credentialsErrorText);
    }

    public String getLoginPageTitleText() {
        return getText(loginPageTitleText);
    }
}
