package com.automation.steps;

import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;

public class ExperiencesFilterSteps extends BaseSteps{

    @And("user selects prices {string} and {string} for activities")
    public void userSelectsPricesAndForActivities(String minimumPrice, String maximumPrice) {
        experiencesFilterPage.selectPriceRange(ConfigReader.getConfigValue(minimumPrice),ConfigReader.getConfigValue(maximumPrice));
    }

    @And("user select a type {string}")
    public void userSelectAType(String activityType) {
        experiencesFilterPage.selectActivityType(ConfigReader.getConfigValue(activityType));
    }
}
