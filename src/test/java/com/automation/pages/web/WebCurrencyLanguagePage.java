package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.CurrencyLanguagePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebCurrencyLanguagePage extends BasePage implements CurrencyLanguagePage {

    @FindBy(id = "tab--language_region_and_currency--1")
    WebElement currencyTab;

    @FindBy(id = "tab--language_region_and_currency--0")
    WebElement languageTab;

    String XPATH_CURRENCY_NAME = "//button[@class='_5af8mpi']/div[text()='%s']";

    String XPATH_CURRENCY_SYMBOL = "//button[@class='_5af8mpi']/div[text()='%s']/following-sibling::div";

    String XPATH_LANGUAGE_NAME = "//li[@class='_obr3yz']//div[text()='%s']/..";

    @Override
    public void clickOnCurrencyTab() {
        currencyTab.click();
    }

    @Override
    public boolean isCurrencyTabSelected() {
        return currencyTab.getAttribute("aria-selected").equals("true");
    }

    @Override
    public void selectCurrencyName(String currency) {
        WebElement currencySymbolElement = driver.findElement(By.xpath(String.format(XPATH_CURRENCY_SYMBOL,currency)));
        String currencySymbol = currencySymbolElement.getText().replaceAll("[^\\p{Sc}]","");
        ConfigReader.setConfigValue("currency.symbol",currencySymbol);
        WebElement currencyName = driver.findElement(By.xpath(String.format(XPATH_CURRENCY_NAME,currency)));
        currencyName.click();
        pause(3000);

    }

    @Override
    public boolean isLanguageTabSelected() {
        return languageTab.getAttribute("aria-selected").equals("true");
    }

    @Override
    public void selectLanguage(String language) {
        WebElement languageName = driver.findElement(By.xpath(String.format(XPATH_LANGUAGE_NAME,language)));
        languageName.click();
        pause(3000);
    }
}
