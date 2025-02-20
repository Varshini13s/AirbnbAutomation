package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.WishlistPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class WebWishlistPage extends BasePage implements WishlistPage {

    @FindBy(xpath = "//button[@aria-label='Close']")
    WebElement recentlyViewedPopup;

    @FindBy(xpath = "//button[contains(@aria-label,'Remove from wishlist')]")
    WebElement removeFromWishlistButton;

    @FindBy(xpath = "//button[@aria-label='Back']")
    WebElement backButton;

    @FindBy(xpath = "//div[@data-testid='listing-card-subtitle' and contains(@class,'fb4nyux')]")
    WebElement numberOfSavedPlaces;

    String XPATH_SAVED_WISHLIST_NAME = "//div[@data-testid='listing-card-title' and text()='%s']";

    String XPATH_SAVED_WISHLIST_CONTAINER = "//div[@data-testid='card-container']//a[contains(@aria-label,'%s')]";

    @Override
    public boolean isWishlistNameDisplayed(String wishlistName) {
        if(isDisplayed(recentlyViewedPopup)){
            recentlyViewedPopup.click();
        }
        WebElement savedWishlistName = driver.findElement(By.xpath(String.format(XPATH_SAVED_WISHLIST_NAME, wishlistName)));
        return savedWishlistName.isDisplayed();
    }

    @Override
    public boolean isPlaceAddedToWishlist() {
        String savedPlaces = numberOfSavedPlaces.getText().replaceAll("[^0-9]","");
        int numberOfSavedPlaces = Integer.parseInt(savedPlaces);
        return numberOfSavedPlaces>0;
    }

    @Override
    public void clickOnWishlist(String wishlistName) {
        WebElement savedWishlistName = driver.findElement(By.xpath(String.format(XPATH_SAVED_WISHLIST_CONTAINER, wishlistName)));
        savedWishlistName.click();
    }

    @Override
    public void deselectWishlistButton() {
        removeFromWishlistButton.click();
        backButton.click();
        pause(2000);
    }

    @Override
    public boolean isPlaceRemovedFromWishlist() {
        String savedPlaces = numberOfSavedPlaces.getText().replaceAll("[^0-9]","");
        int numberOfSavedPlaces = Integer.parseInt(savedPlaces);
        return numberOfSavedPlaces==0;
    }
}
