package com.automation.pages.ui;

public interface HomePage {

    void openApplication();

    void clickLoginIcon();

    void clickLoginOption();

    boolean isLoginSuccessful();

    void clickLogoutOption();

    boolean isLogoutSuccessful();

    boolean isHomePageDisplayed();

    boolean isStaysButtonSelected();

    void selectDestination(String destinationName);

    void selectDates(String checkinDate, String checkoutDate);

    void selectGuests();

    void clickOnSearchButton();

    void clickOnExperiencesButton();

    boolean isExperiencesButtonSelected();

    void createNewWishlist(String wishlist);

    void clickOnWishlistsIcon();

    void clickOnAddToWishlistButton();

    default void clickOnSettings(){

    }

    default void clickExploreIcon(){

    }

    boolean isCurrencyApplied();

    default void clickGlobeIcon(){

    }

    default boolean isLanguageApplied(String attributeValue){
        return false;
    }

    void clickFeedbackOption();

    void clickProfileIcon();

    void getFirstPlaceDetails();

    void clickMapButton();
}
