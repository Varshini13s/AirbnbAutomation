package com.automation.pages.ui;

public interface WishlistPage {

    boolean isWishlistNameDisplayed(String wishlistName);

    default void clickOnWishlist(String wishlistName){

    }

    default void deselectWishlistButton(){

    }

    default boolean isPlaceRemovedFromWishlist(){
        return false;
    }

    boolean isPlaceAddedToWishlist();

    default void clickEditButton(){

    }

    default void deleteWishlist(){

    }
}
