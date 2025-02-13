package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidLoginPage extends BasePage implements LoginPage {

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.airbnb.android:id/title_text']")
    WebElement loginText;

    @FindBy(id = "com.airbnb.android:id/caret")
    WebElement countryDropDown;

    @FindBy(id = "android:id/select_dialog_listview")
    WebElement countryDropDownBox;

    @FindBy(id = "com.airbnb.android:id/edit_text")
    WebElement phoneNumberInput;

    @FindBy(id = "com.airbnb.android:id/gradient_button_row_button")
    WebElement continueButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Confirm your number']")
    WebElement numberConfirmationText;

    String XPATH_COUNTRY_OPTION = "//android.widget.CheckedTextView[@resource-id='android:id/text1' and contains(@text,'%s') and contains(@text,'%s')]" ;

    @Override
    public boolean isLoginPopupDisplayed() {
        return loginText.isDisplayed();
    }

    @Override
    public void enterCountryAndPhoneNumber(String countryName, String countryCode, String phoneNumber) {
        countryDropDown.click();
        while (!isDisplayed(String.format(XPATH_COUNTRY_OPTION,countryName,countryCode))){
            int x = countryDropDownBox.getLocation().getX();
            int y = countryDropDownBox.getLocation().getY();
            int width = countryDropDownBox.getSize().getWidth();
            int height = countryDropDownBox.getSize().getHeight();
            scroll(x+width/2,y,x+width/2,height);
        }
        WebElement countryOption = driver.findElement(By.xpath(String.format(XPATH_COUNTRY_OPTION,countryName,countryCode)));
        countryOption.click();
        phoneNumberInput.sendKeys(phoneNumber);
        continueButton.click();
    }

    @Override
    public boolean isOtpPopupDisplayed() {
        return numberConfirmationText.isDisplayed();
    }

    @Override
    public void userEnterOtp() {
        pause(20000);
    }
}
