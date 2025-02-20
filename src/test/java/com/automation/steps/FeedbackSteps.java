package com.automation.steps;

import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FeedbackSteps extends BaseSteps{
    @Then("verify user is on feedback page")
    public void verifyUserIsOnFeedbackPage() {
        Assert.assertTrue(feedbackPage.isFeedbackPageDisplayed());
    }

    @When("user select feedback theme {string}")
    public void userSelectFeedbackTheme(String feedbackTheme) {
        feedbackPage.selectFeedbackTheme(ConfigReader.getConfigValue(feedbackTheme));
    }

    @And("user select feedback type {string}")
    public void userSelectFeedbackType(String feedbackType) {
        feedbackPage.selectFeedbackType(ConfigReader.getConfigValue(feedbackType));
    }

    @And("user gives feedback message {string}")
    public void userGivesFeedbackMessage(String feedbackMessage) {
        feedbackPage.giveFeedbackMessage(ConfigReader.getConfigValue(feedbackMessage));
    }

    @Then("verify feedback is shared successfully")
    public void verifyFeedbackIsSharedSuccessfully() {
        Assert.assertTrue(feedbackPage.isSuccessMessageDisplayed());
    }

}
