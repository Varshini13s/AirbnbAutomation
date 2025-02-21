package com.automation.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CurrencySteps extends BaseSteps {

    @And("user select currency {string}")
    public void userSelectCurrency(String currency) {
        currencyPage.selectCurrency(currency);
    }

}
