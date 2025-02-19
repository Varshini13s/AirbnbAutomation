package com.automation.pages.ui;

public interface WishlistPage {

    boolean isWishlistNameDisplayed(String wishlistName);

    void clickOnWishlist(String wishlistName);

    void deselectWishlistButton();

    boolean isPlaceRemovedFromWishlist();

    boolean isPlaceAddedToWishlist();
}
