package com.automation.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MapSteps extends BaseSteps{
    @Then("verify location price marker of first place is displayed")
    public void verifyLocationPriceMarkerOfFirstPlaceIsDisplayed() {
        Assert.assertTrue(mapPage.isLocationPriceMarkerDisplayed());
    }

    @When("user click on price marker")
    public void userClickOnPriceMarker() {
        mapPage.clickPriceMarker();
    }

    @Then("verify place details is displayed")
    public void verifyPlaceDetailsIsDisplayed() {
        Assert.assertTrue(mapPage.isPlaceDetailDisplayed());
    }
}
