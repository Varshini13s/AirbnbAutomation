package com.automation.steps;

import com.automation.pages.android.AndroidLoginPage;
import com.automation.pages.ui.LoginPage;
import com.automation.pages.web.WebLoginPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps extends BaseSteps{

    @Then("verify login popup is displayed")
    public void verifyLoginPopupIsDisplayed() {
        Assert.assertTrue(loginPage.isLoginPopupDisplayed());
    }

    @When("user enter valid credentials {string}, {string} and {string}")
    public void userEnterValidCredentials(String countryName, String countryCode, String phoneNumber) {
        loginPage.enterCountryAndPhoneNumber(ConfigReader.getConfigValue(countryName),ConfigReader.getConfigValue(countryCode),ConfigReader.getConfigValue(phoneNumber));
    }

    @Then("verify otp popup is displayed")
    public void verifyOtpPopupIsDisplayed() {
       Assert.assertTrue(loginPage.isOtpPopupDisplayed());
    }

    @When("user enter the otp")
    public void userEnterTheOtp() {
        loginPage.userEnterOtp();
    }

}
