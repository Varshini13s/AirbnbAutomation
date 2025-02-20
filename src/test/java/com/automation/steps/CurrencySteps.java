package com.automation.steps;

import io.cucumber.java.en.And;

public class CurrencySteps extends BaseSteps {

    @And("user select currency {string}")
    public void userSelectCurrency(String currency) {
        currencyPage.selectCurrency(currency);
    }
}
