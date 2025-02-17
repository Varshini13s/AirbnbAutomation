package com.automation.pages.ui;

public interface HomePage {

    void openApplication();

    void clickProfileIcon();

    void clickLoginOption();

    boolean isLoginSuccessful();

    void clickLogoutOption();

    boolean isLogoutSuccessful();

    boolean isHomePageDisplayed();

    boolean isStaysButtonSelected();

    void selectDestination(String configValue);

    void selectDates(String configValue, String configValue1);

    void selectGuests();

    void clickOnSearchButton();

    void clickOnExperiencesButton();

    boolean isExperiencesButtonSelected();
}
