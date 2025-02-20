package com.automation.steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;

public class PlaceDescriptionSteps extends BaseSteps {

    @Then("verify amenities filter is applied to places")
    public void verifyAmenitiesFilterIsAppliedToPlaces() {
        staysPage.scrollOverMap();
        Assert.assertTrue(placeDescriptionPage.isAmenitiesFilterApplied());
    }

    @Then("verify host language filter is applied to places")
    public void verifyHostLanguageFilterIsAppliedToPlaces() {
        staysPage.scrollOverMap();
        Assert.assertTrue(placeDescriptionPage.isHostLanguageFilterApplied());
    }
}
