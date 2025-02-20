package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.FeedbackPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidFeedbackPage extends BasePage implements FeedbackPage {

    @FindBy(xpath = "//android.view.View[@text='Share your feedback']")
    WebElement feedbackPageTitle;

    @FindBy(xpath = "//android.view.View[@resource-id='select_feedback_theme']")
    WebElement feedbackThemeDropdown;

    @FindBy(xpath = "//android.view.View[@resource-id='select_feedback_type']")
    WebElement feedbackTypeDropdown;

    @FindBy(xpath = "//android.view.View[@resource-id='react-application']")
    WebElement feedbackPageLayout;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='textarea_feedback']")
    WebElement feedbackInput;

    @FindBy(xpath = "//android.widget.Button[@text='Submit']")
    WebElement submitButton;

    @FindBy(xpath = "//android.view.View[@text='Thanks for your feedback!']")
    WebElement successMessage;

    String XPATH_FEEDBACK_OPTIONS = "//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='%s']";

    @Override
    public void selectFeedbackTheme(String feedbackTheme) {
        feedbackThemeDropdown.click();
        WebElement feedbackThemeOption = driver.findElement(By.xpath(String.format(XPATH_FEEDBACK_OPTIONS,feedbackTheme)));
        feedbackThemeOption.click();
    }

    @Override
    public void selectFeedbackType(String feedbackType) {
        feedbackTypeDropdown.click();
        WebElement feedbackTypeOption = driver.findElement(By.xpath(String.format(XPATH_FEEDBACK_OPTIONS,feedbackType)));
        feedbackTypeOption.click();
    }

    @Override
    public boolean isFeedbackPageDisplayed() {
        return feedbackPageTitle.isDisplayed();
    }

    @Override
    public void giveFeedbackMessage(String feedbackMessage) {
        while (!isDisplayed(feedbackInput)){
            int x = feedbackPageLayout.getLocation().getX();
            int y = feedbackPageLayout.getLocation().getY();
            int height = feedbackPageLayout.getSize().getHeight();
            int width = feedbackPageLayout.getSize().getWidth();
            scroll(x+width/2,height,x+width/2,y);
        }
        feedbackInput.sendKeys(feedbackMessage);
        submitButton.click();
    }

    @Override
    public boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }
}
