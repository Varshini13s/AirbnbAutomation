package com.automation.steps;

import com.automation.utils.ConfigReader;
import io.cucumber.java.bs.A;
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

    @When("user click on login icon")
    public void userClickOnLoginIcon() {
        homePage.clickLoginIcon();
    }

    @And("user click on login option")
    public void userClickOnLoginOption() {
        homePage.clickLoginOption();
    }

    @Then("verify login is successful")
    public void verifyLoginIsSuccessful() {
        homePage.clickProfileIcon();
        Assert.assertTrue(homePage.isLoginSuccessful());
    }

    @When("user click on profile icon")
    public void userClickOnProfileIcon() {
        homePage.clickProfileIcon();
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

    @When("user click on add to wishlist button on the image")
    public void userClickOnAddToWishlistButtonOnTheImage() {
        homePage.clickOnAddToWishlistButton();
    }

    @And("user create new wishlist with name {string}")
    public void userCreateNewWishlistWithName(String wishlistName) {
        homePage.createNewWishlist(ConfigReader.getConfigValue(wishlistName));
    }

    @When("user click on wishlists icon")
    public void userClickOnWishlistsIcon() {
        homePage.clickOnWishlistsIcon();
    }

    @And("user click on settings option")
    public void userClickOnSettingsOption() {
        homePage.clickOnSettings();
    }

    @Then("verify currency is displayed")
    public void verifyCurrencyIsDisplayed() {
        Assert.assertTrue(homePage.isCurrencyApplied());
    }

    @When("user click on globe icon")
    public void userClickOnGlobeIcon() {
        homePage.clickGlobeIcon();
    }

    @Then("verify currency symbol is displayed")
    public void verifyCurrencySymbolIsDisplayed() {
        Assert.assertTrue(homePage.isCurrencyApplied());
    }

    @Then("verify language is applied using {string}")
    public void verifyLanguageIsApplied(String attributeValue) {
        Assert.assertTrue(homePage.isLanguageApplied(attributeValue));
    }

    @And("click on give us feedback option")
    public void clickOnGiveUsFeedbackOption() {
        homePage.clickFeedbackOption();
    }
}