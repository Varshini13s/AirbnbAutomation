package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.HomePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebHomePage extends BasePage implements HomePage {
    
    @FindBy(xpath = "//button[@data-tooltip-anchor-id='headernav-profile-button']//div[contains(@class,'fs7xov7')]")
    WebElement userProfileIcon;

    @FindBy(xpath = "//div[text()='Log in']")
    WebElement loginOption;

    @FindBy(xpath = "//div[text()='Log out']")
    WebElement logoutOption;

    @FindBy(xpath = "//div[text()='Account']")
    WebElement accountOption;
    
    public void openApplication() {
        driver.get(ConfigReader.getConfigValue("application.url"));
    }

    public void clickProfileIcon() {
        userProfileIcon.click();
    }

    public void clickLoginOption() {
        loginOption.click();
    }

    public boolean isLoginSuccessful() {
        userProfileIcon.click();
        return logoutOption.isDisplayed() && accountOption.isDisplayed();
    }

    @Override
    public void clickLogoutOption() {
        logoutOption.click();
    }

    @Override
    public boolean isLogoutSuccessful() {
        pause(5000);
        userProfileIcon.click();
        return loginOption.isDisplayed();
    }
}
