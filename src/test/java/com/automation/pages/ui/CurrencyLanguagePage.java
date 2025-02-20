package com.automation.pages.ui;

public interface CurrencyLanguagePage {
    void clickOnCurrencyTab();

    boolean isCurrencyTabSelected();

    void selectCurrencyName(String currency);

    boolean isLanguageTabSelected();

    void selectLanguage(String language);
}
