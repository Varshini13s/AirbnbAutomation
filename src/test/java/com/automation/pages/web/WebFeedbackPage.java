package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.FeedbackPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class WebFeedbackPage extends BasePage implements FeedbackPage {

    @FindBy(id = "FMP-target")
    WebElement feedbackPageTitle;

    @FindBy(id = "select_feedback_theme")
    WebElement feedbackThemeDropdown;

    @FindBy(id = "select_feedback_type")
    WebElement feedbackTypeDropdown;

    @FindBy(xpath = "//textarea[@name='textarea_feedback']")
    WebElement feedbackInput;

    @FindBy(xpath = "//button[text()='Submit']")
    WebElement submitButton;

    @FindBy(xpath = "//div[text()='Thanks for your feedback!']")
    WebElement successMessage;

    @Override
    public void selectFeedbackTheme(String feedbackTheme) {
        Select select = new Select(feedbackThemeDropdown);
        select.selectByVisibleText(feedbackTheme);
    }

    @Override
    public void selectFeedbackType(String feedbackType) {
        Select select = new Select(feedbackTypeDropdown);
        select.selectByVisibleText(feedbackType);
    }

    @Override
    public boolean isFeedbackPageDisplayed() {
        return feedbackPageTitle.isDisplayed();
    }

    @Override
    public void giveFeedbackMessage(String feedbackMessage) {
        feedbackInput.sendKeys(feedbackMessage);
        submitButton.click();
    }

    @Override
    public boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }
}
