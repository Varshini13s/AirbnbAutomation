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

    @Given("user open website or application")
    public void userOpenWebsiteOrApplication() {
        homePage.openApplication();
    }

    @Then("verify user is on home page")
    public void verifyUserIsOnHomePage() {
        Assert.assertTrue(homePage.isHomePageDisplayed());
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

    @And("verify stays button is selected")
    public void verifyStaysButtonIsSelected() {
        Assert.assertTrue(homePage.isStaysButtonSelected());
    }

    @When("user selects {string}, {string} and {string}")
    public void userSelectsDetails(String destinationName, String checkinDate, String checkoutDate) {
        homePage.selectDestination(ConfigReader.getConfigValue(destinationName));
        homePage.selectDates(ConfigReader.getConfigValue(checkinDate),ConfigReader.getConfigValue(checkoutDate));
    }

    @And("user selects number of guests")
    public void userSelectsNumberOfGuests() {
        homePage.selectGuests();
        homePage.clickOnSearchButton();
    }

    @When("user click on experiences button")
    public void userClickOnExperiencesButton() {
        homePage.clickOnExperiencesButton();
    }

    @Then("verify experiences button is selected")
    public void verifyExperiencesButtonIsSelected() {
        Assert.assertTrue(homePage.isExperiencesButtonSelected());
    }
}