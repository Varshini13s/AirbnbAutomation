package com.automation.pages.ui;

public interface LoginPage {
    boolean isLoginPopupDisplayed();

    void selectCountryDetails(String countryName, String countryCode);

    boolean isOtpPopupDisplayed();

    void userEnterOtp();

    void enterPhoneNumber(String phoneNumber);

    void enterInvalidPhoneNumber(String phoneNumber);

    boolean isErrorMessageDisplayed();
}
