package com.automation.pages.ui;

public interface LoginPage {
    boolean isLoginPopupDisplayed();

    void enterCountryAndPhoneNumber(String configValue, String configValue1, String value);

    boolean isOtpPopupDisplayed();

    void userEnterOtp();
}
