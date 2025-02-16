package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidHomePage extends BasePage implements HomePage {

    @FindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    WebElement doNotAllowButton;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Close']")
    WebElement closeButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.airbnb.android:id/navigation_bar_item_small_label_view' and @text='Log In']")
    WebElement loginIcon;

    @FindBy(id = "com.airbnb.android:id/gradient_button_row_button")
    WebElement loginButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Show profile']")
    WebElement showProfileText;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.airbnb.android:id/navigation_bar_item_small_label_view' and @text='Profile']")
    WebElement profileIcon;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.airbnb.android:id/base_row_text' and @text='Log out']")
    WebElement logoutOption;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.airbnb.android:id/content_container']")
    WebElement profileLayout;

    @FindBy(id = "com.airbnb.android:id/n2_dls_action_footer_gradient_button")
    WebElement logoutButton;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Close']")
    WebElement logoutCloseButton;

    @FindBy(id = "com.airbnb.android:id/search_input_bar")
    WebElement searchButton;

    @Override
    public void openApplication() {
        if(isDisplayed(doNotAllowButton)){
            doNotAllowButton.click();
        }
        if(isDisplayed(closeButton)){
            closeButton.click();
        }

    }

    @Override
    public boolean isHomePageIsDisplayed() {
        return loginIcon.isDisplayed() && searchButton.isDisplayed();
    }

    @Override
    public boolean isStaysButtonSelected() {
        return false;
    }

    @Override
    public void selectDestination(String configValue) {

    }

    @Override
    public void selectDates(String configValue, String configValue1) {

    }

    @Override
    public void selectGuests() {

    }

    @Override
    public void clickOnSearchButton() {

    }

    @Override
    public void clickOnExperiencesButton() {

    }

    @Override
    public boolean isExperiencesButtonSelected() {
        return false;
    }

    @Override
    public void clickProfileIcon() {
        loginIcon.click();
    }

    @Override
    public void clickLoginOption() {
        loginButton.click();
    }

    @Override
    public boolean isLoginSuccessful() {
        profileIcon.click();
        return showProfileText.isDisplayed();
    }

    @Override
    public void clickLogoutOption() {
        while (!isDisplayed(logoutOption)){
            int x = profileLayout.getLocation().getX();
            int y = profileLayout.getLocation().getY();
            int height = profileLayout.getSize().getHeight();
            int width = profileLayout.getSize().getWidth();
            scroll(x+width/2,height,x+width/2,y);
        }
        logoutOption.click();
        logoutButton.click();
        if(isDisplayed(logoutCloseButton)) {
            logoutCloseButton.click();
        }
    }

    @Override
    public boolean isLogoutSuccessful() {
        return loginIcon.isDisplayed();
    }
}
