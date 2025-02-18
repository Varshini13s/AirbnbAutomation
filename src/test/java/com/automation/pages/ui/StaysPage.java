package com.automation.pages.ui;

public interface StaysPage {
    boolean arePlacesDisplayed();

    void clickFilterButton();

    boolean isPriceFilterApplied();

    boolean isAmenitiesFilterApplied();

    boolean isHostLanguageFilterApplied();

    default void scrollOverMap() {
    }


}
