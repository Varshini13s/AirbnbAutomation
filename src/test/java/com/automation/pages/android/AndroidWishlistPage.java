package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.WishlistPage;

public class AndroidWishlistPage extends BasePage implements WishlistPage {

    @Override
    public boolean isWishlistNameDisplayed(String wishlistName) {
        return false;
    }

    @Override
    public void clickOnWishlist(String wishlistName) {

    }

    @Override
    public void deselectWishlistButton() {

    }

    @Override
    public boolean isPlaceRemovedFromWishlist() {
        return false;
    }

    @Override
    public boolean isPlaceAddedToWishlist() {
        return false;
    }
}
