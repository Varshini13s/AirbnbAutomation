package com.automation.steps;

import com.automation.pages.android.AndroidHomePage;
import com.automation.pages.ui.HomePage;
import com.automation.pages.web.WebHomePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps extends BaseSteps {

    @Given("user open website")
    public void userOpenWebsite() {
        homePage.openApplication();
    }

    @When("user click on profile icon")
    public void userClickOnProfileIcon() {
        homePage.clickProfileIcon();
    }

    @And("user click on login option")
    public void userClickOnLoginOption() {
        homePage.clickLoginOption();
    }

    @Then("verify login is successful")
    public void verifyLoginIsSuccessful() {
        Assert.assertTrue(homePage.isLoginSuccessful());
    }

    @When("user click on logout option")
    public void userClickOnLogoutOption() {
        homePage.clickLogoutOption();
    }

    @Then("verify logout is successful")
    public void verifyLogoutIsSuccessful() {
        Assert.assertTrue(homePage.isLogoutSuccessful());
    }
}
