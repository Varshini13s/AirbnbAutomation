package com.automation.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CurrencyLanguageSteps extends BaseSteps {

    @And("user click on currency tab")
    public void userClickOnCurrencyTab() {
        currencyLanguagePage.clickOnCurrencyTab();
    }

    @Then("verify currency tab is selected")
    public void verifyCurrencyTabIsSelected() {
        Assert.assertTrue(currencyLanguagePage.isCurrencyTabSelected());
    }

    @When("user select currency name {string}")
    public void userSelectCurrencyName(String currency) {
        currencyLanguagePage.selectCurrencyName(currency);
    }

    @Then("verify language tab is selected")
    public void verifyLanguageTabIsSelected() {
        Assert.assertTrue(currencyLanguagePage.isLanguageTabSelected());
    }

    @When("user selects language {string}")
    public void userSelectsLanguage(String languageName) {
        currencyLanguagePage.selectLanguage(languageName);
    }

}
