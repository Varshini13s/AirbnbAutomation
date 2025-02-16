package com.automation.steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ExperiencesSteps extends BaseSteps {

    @Then("verify activities are displayed")
    public void verifyActivitiesAreDisplayed() {
        Assert.assertTrue(experiencesPage.arePlacesDisplayed());

    }
}
