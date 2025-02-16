package com.automation.steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;

public class StaysSteps extends BaseSteps {

    @Then("verify places are displayed")
    public void verifyPlacesAreDisplayed() {
        Assert.assertTrue(staysPage.arePlacesDisplayed());
    }
}
