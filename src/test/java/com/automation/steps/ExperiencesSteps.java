package com.automation.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ExperiencesSteps extends BaseSteps {

    @Then("verify activities are displayed")
    public void verifyActivitiesAreDisplayed() {
        Assert.assertTrue(experiencesPage.areActivitiesDisplayed());

    }

    @When("user click on filters button in experiences page")
    public void userClickOnFiltersButtonInExperiencesPage() {
        experiencesPage.clickOnFiltersButton();
    }

    @When("user click on price filter button")
    public void userClickOnPriceFilterButton() {
        experiencesPage.clickOnPriceButton();
    }

    @Then("verify price filter is applied to activities")
    public void verifyPriceFilterIsAppliedToActivities() {
        Assert.assertTrue(experiencesPage.isPriceFilterApplied());
    }

    @Then("verify type filter is applied to activities")
    public void verifyTypeFilterIsAppliedToActivities() {
        Assert.assertTrue(experiencesPage.isActivityTypeFilterApplied());
    }
}
