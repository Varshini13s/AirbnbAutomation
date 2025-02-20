package com.automation.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SettingsSteps extends BaseSteps{

    @Then("verify user is on settings page")
    public void verifyUserIsOnSettingsPage() {
        Assert.assertTrue(settingsPage.isSettingsPageDisplayed());
    }

    @When("user click on currency option")
    public void userClickOnCurrencyOption() {
        settingsPage.clickOnCurrencyOption();
    }

    @When("user navigates to home page")
    public void userNavigatesToHomePage() {
        settingsPage.navigateToHomePage();
        homePage.clickExploreIcon();
    }
}
