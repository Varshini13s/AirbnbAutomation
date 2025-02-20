package com.automation.pages.ui;

public interface StaysPage {
    boolean arePlacesDisplayed();

    void clickFilterButton();

    boolean isPriceFilterApplied();

    default void scrollOverMap() {
    }


}
