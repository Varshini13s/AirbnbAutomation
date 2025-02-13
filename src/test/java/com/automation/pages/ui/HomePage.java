package com.automation.pages.ui;

public interface HomePage {
    void openApplication();

    void clickProfileIcon();

    void clickLoginOption();

    boolean isLoginSuccessful();

    void clickLogoutOption();

    boolean isLogoutSuccessful();
}
