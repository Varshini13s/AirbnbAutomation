package com.automation.pages.ui;

public interface ExperiencesPage {
    boolean areActivitiesDisplayed();

    void clickOnFiltersButton();

    default void clickOnPriceButton(){

    }

    boolean isPriceFilterApplied();

    default boolean isActivityTypeFilterApplied(){
        return false;
    }
}
