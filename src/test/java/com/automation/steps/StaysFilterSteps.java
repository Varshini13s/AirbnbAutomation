package com.automation.steps;

import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;

public class StaysFilterSteps extends BaseSteps{

    @And("user selects prices {string} and {string}")
    public void userSelectsPrices(String minimumPrice, String maximumPrice) {
        staysFilterPage.selectPriceRange(ConfigReader.getConfigValue(minimumPrice),ConfigReader.getConfigValue(maximumPrice));
        staysFilterPage.getFilterResult();
    }

    @And("user selects amenities {string}")
    public void userSelectsAmenities(String amenitiesOption) {
        staysFilterPage.selectAmenities(ConfigReader.getConfigValue(amenitiesOption));
        staysFilterPage.getFilterResult();
    }

    @And("user selects language {string}")
    public void userSelectsLanguage(String hostLanguage) {
        staysFilterPage.selectHostLanguage(ConfigReader.getConfigValue(hostLanguage));
        staysFilterPage.getFilterResult();
    }

}
