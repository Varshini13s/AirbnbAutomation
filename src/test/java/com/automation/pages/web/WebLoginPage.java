package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebLoginPage extends BasePage implements LoginPage {

    @FindBy(xpath = "//div[text()='Log in or sign up']")
    WebElement loginText;

    @FindBy(xpath = "//input[@data-testid='login-signup-phonenumber']")
    WebElement phoneNumberInput;

    @FindBy(xpath = "//select[@data-testid='login-signup-countrycode']")
    WebElement countryDropDown;

    @FindBy(xpath = "//button[@data-testid='signup-login-submit-btn']")
    WebElement continueButton;

    @FindBy(xpath = "//div[text()='Confirm your number']")
    WebElement numberConfirmationText;

    String XPATH_COUNTRY_OPTION = "//select//option[text()='%s' and text()='%s']";

    @FindBy(id = "phone-number-error-phone-login")
    WebElement errorMessage;

    @FindBy(xpath = "//div[@class='m1us9lga dir dir-ltr']")
    WebElement invalidMessage;

    public boolean isLoginPopupDisplayed() {
        return loginText.isDisplayed();
    }

    public void selectCountryDetails(String countryName, String countryCode) {
        countryDropDown.click();
        WebElement countryOption = driver.findElement(By.xpath(String.format(XPATH_COUNTRY_OPTION,countryName,countryCode)));
        countryOption.click();
    }

    @Override
    public void enterPhoneNumber(String phoneNumber) {
        phoneNumberInput.click();
        phoneNumberInput.sendKeys(phoneNumber);
        continueButton.click();
    }

    @Override
    public void enterInvalidPhoneNumber(String phoneNumber) {
        phoneNumberInput.click();
        phoneNumberInput.sendKeys(phoneNumber);
        continueButton.click();
    }

    @Override
    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed() || invalidMessage.isDisplayed();
    }

    public boolean isOtpPopupDisplayed() {
        return numberConfirmationText.isDisplayed();
    }

    public void userEnterOtp() {
        pause(30000);
    }

}
