package com.automation.steps;

import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StaysSteps extends BaseSteps {

    @Then("verify places are displayed")
    public void verifyPlacesAreDisplayed() {
        Assert.assertTrue(staysPage.arePlacesDisplayed());
    }

    @When("user click on filters button in stays page")
    public void userClickOnFiltersButton() {
        staysPage.clickFilterButton();
    }

    @Then("verify price filter is applied to places")
    public void verifyPriceFilterIsAppliedToPlaces() {
        staysPage.scrollOverMap();
        Assert.assertTrue(staysPage.isPriceFilterApplied());
    }

    @Then("verify amenities filter is applied to places")
    public void verifyAmenitiesFilterIsAppliedToPlaces() {
        staysPage.scrollOverMap();
        Assert.assertTrue(staysPage.isAmenitiesFilterApplied());
    }

    @Then("verify host language filter is applied to places")
    public void verifyHostLanguageFilterIsAppliedToPlaces() {
        staysPage.scrollOverMap();
        Assert.assertTrue(staysPage.isHostLanguageFilterApplied());
    }
}
