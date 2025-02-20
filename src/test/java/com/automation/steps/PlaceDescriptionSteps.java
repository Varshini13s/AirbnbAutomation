package com.automation.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    @Then("verify price is same in place description page")
    public void verifyPriceIsSameInPlaceDescriptionPage() {
        Assert.assertTrue(placeDescriptionPage.isPriceConstant());
    }

    @When("user click on reserve button")
    public void userClickOnReserveButton() {
        placeDescriptionPage.clickReserveButton();
    }

    @Then("verify total price including taxes")
    public void verifyTotalPriceIncludingTaxes() {
        Assert.assertTrue(placeDescriptionPage.verifyTotalPrice());
    }
}
