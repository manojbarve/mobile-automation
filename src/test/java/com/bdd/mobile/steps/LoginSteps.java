package com.bdd.mobile.steps;

/*
 * This class is the cucumber step definition class or glue code for the cucumber test cases
 */

import com.bdd.mobile.base.Utility;
import com.bdd.mobile.pages.LoginPage;
import com.bdd.mobile.pages.MenuPage;
import com.bdd.mobile.pages.ProductsDetailsPage;
import com.bdd.mobile.pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

import java.io.IOException;

public class LoginSteps {

    MenuPage menupage;
    LoginPage loginPage;
    ProductsPage prodPage;
    ProductsDetailsPage prodDetailsPage;

    @Before
    public void setup() {
        menupage = new MenuPage();
        loginPage = new LoginPage();
        prodPage = new ProductsPage();
        prodDetailsPage = new ProductsDetailsPage();
    }

    @Test
    @Given("user launch the mobile application")
    public void userLaunchTheMobileApp() throws IOException {
        try {
            if (this.menupage == null) {
                setup();
            }
            menupage.navigateToLogin();
        } catch (Exception E) {
            Utility.getScreenshot("loginfailure");
        }
    }

    @Then("user enters {string} and {string}")
    public void enterAnd(String userName, String password) throws IOException {
        try {
            Assert.assertEquals(loginPage.getLoginPageTitleText(), "Login");
            loginPage.login(userName, password);
        } catch (Exception E) {
            Utility.getScreenshot("loginfailure");
        }
    }

    @When("after successful login navigate to product page")
    public void navigateToProductPageAfterSuccessfulLogin() throws IOException {
        try {
            Assert.assertTrue(prodPage.waitForProductText());
            System.out.println("login is successful");
        } catch (Exception E) {
            Utility.getScreenshot("product_page");
        }
    }

    @And("navigate to the bottom of the page and select the product")
    public void navigateToTheBottomOfThePageAndSelectTheProduct() throws IOException {
        try {
            Utility.scroll(Utility.ScrollDirection.DOWN, 0.2);
            Utility.scroll(Utility.ScrollDirection.DOWN, 0.3);
            prodPage.selectLastProduct();
        } catch (Exception E) {
            Utility.getScreenshot("product_selection");
        }
    }

    @Then("validate whether the product selection is successful")
    public void validateWhetherTheProductSelectionIsSuccessful() throws InterruptedException, IOException {
        try {
            if (prodDetailsPage.waitForProductDetailsText()) {
                Assert.assertTrue(prodDetailsPage.waitForProductDetailsText());
            }
        } catch (Exception E) {
            Utility.getScreenshot("product_selection");
        }
    }
    @And("validate whether the login is unsuccessful")
    public void validateWhetherTheLoginIsUnSuccessful() throws InterruptedException, IOException {
        try {
            Assert.assertEquals(loginPage.getCredentialsErrorText(), "Provided credentials do not match any user in this service.");
        } catch (Exception E) {
            Utility.getScreenshot("loginFailure");
        }
    }
}

