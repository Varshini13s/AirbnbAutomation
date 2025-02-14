package com.automation.steps;

import com.automation.pages.android.AndroidLoginPage;
import com.automation.pages.ui.LoginPage;
import com.automation.pages.web.WebLoginPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps extends BaseSteps{

    @Then("verify login popup is displayed")
    public void verifyLoginPopupIsDisplayed() {
        Assert.assertTrue(loginPage.isLoginPopupDisplayed());
    }

    @When("user selects the country {string} with code {string}")
    public void userSelectCountryDetails(String countryName, String countryCode) {
        loginPage.selectCountryDetails(ConfigReader.getConfigValue(countryName),ConfigReader.getConfigValue(countryCode));
    }

    @And("user enter valid credential {string}")
    public void userEnterValidCredential(String phoneNumber) {
        loginPage.enterPhoneNumber(ConfigReader.getConfigValue(phoneNumber));
    }

    @Then("verify otp popup is displayed")
    public void verifyOtpPopupIsDisplayed() {
       Assert.assertTrue(loginPage.isOtpPopupDisplayed());
    }

    @When("user enter the otp")
    public void userEnterTheOtp() {
        loginPage.userEnterOtp();
    }

    @And("user enter invalid credential {string}")
    public void userEnterInvalidCredential(String phoneNumber) {
        loginPage.enterInvalidPhoneNumber(phoneNumber);
    }

    @Then("verify error message is displayed")
    public void verifyErrorMessageIsDisplayed() {
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }
}
