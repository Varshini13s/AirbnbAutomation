package com.automation.pages.ui;

public interface PlaceDescriptionPage {

    boolean isAmenitiesFilterApplied();

    boolean isHostLanguageFilterApplied();

    boolean isPriceConstant();

    void clickReserveButton();

    boolean verifyTotalPrice();
}
