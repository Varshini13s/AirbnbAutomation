package com.automation.pages.ui;

public interface FeedbackPage {

    void selectFeedbackTheme(String feedbackTheme);

    void selectFeedbackType(String feedbackType);

    boolean isFeedbackPageDisplayed();

    void giveFeedbackMessage(String feedbackMessage);

    boolean isSuccessMessageDisplayed();
}
