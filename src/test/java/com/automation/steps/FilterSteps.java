package com.automation.steps;

import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class FilterSteps extends BaseSteps{

    @And("user selects prices {string} and {string}")
    public void userSelectsPricesAnd(String minimumPrice, String maximumPrice) {
        filterPage.selectPriceRange(ConfigReader.getConfigValue(minimumPrice),ConfigReader.getConfigValue(maximumPrice));
        filterPage.getFilterResult();
    }

    @And("user selects amenities {string}")
    public void userSelectsAmenities(String amenitiesOption) {
        filterPage.selectAmenities(ConfigReader.getConfigValue(amenitiesOption));
        filterPage.getFilterResult();
    }

    @And("user selects language {string}")
    public void userSelectsLanguage(String hostLanguage) {
        filterPage.selectHostLanguage(ConfigReader.getConfigValue(hostLanguage));
        filterPage.getFilterResult();
    }

}
