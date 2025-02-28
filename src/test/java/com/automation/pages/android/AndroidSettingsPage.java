package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.SettingsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidSettingsPage extends BasePage implements SettingsPage {

    @FindBy(id = "com.airbnb.android:id/title")
    WebElement settingsTitle;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=['com.airbnb.android:id/info_row_title']")
    WebElement currencyOption;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    WebElement backButton;

    @Override
    public boolean isSettingsPageDisplayed() {
        return settingsTitle.isDisplayed();
    }

    @Override
    public void clickOnCurrencyOption() {
        currencyOption.click();
    }

    @Override
    public void navigateToHomePage() {
        backButton.click();
    }
}
