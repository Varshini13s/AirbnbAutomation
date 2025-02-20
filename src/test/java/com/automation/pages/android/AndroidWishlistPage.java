package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.WishlistPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidWishlistPage extends BasePage implements WishlistPage {

    @FindBy(xpath = "//android.view.View[@content-desc='Close']")
    WebElement recentlyViewedPopup;

    @FindBy(xpath = "//android.widget.TextView[@text='Edit']")
    WebElement editButton;

    @FindBy(xpath = "//android.view.View[contains(@content-desc,'Delete')]")
    WebElement removeIcon;

    @FindBy(id = "android:id/button1")
    WebElement deleteButton;

    String XPATH_SAVED_WISHLIST_NAME = "//android.view.View[contains(@content-desc,'%s')]";

    @Override
    public boolean isWishlistNameDisplayed(String wishlistName) {
        if(isDisplayed(recentlyViewedPopup)){
            recentlyViewedPopup.click();
        }
        if(isDisplayed(recentlyViewedPopup)){
            recentlyViewedPopup.click();
        }
        //WebElement savedWishlistName = driver.findElement(By.xpath(String.format(XPATH_SAVED_WISHLIST_NAME, wishlistName)));
        return isDisplayed(String.format(XPATH_SAVED_WISHLIST_NAME, wishlistName));
    }

    @Override
    public boolean isPlaceAddedToWishlist() {
        WebElement savedWishlistName = driver.findElement(By.xpath(String.format(XPATH_SAVED_WISHLIST_NAME, ConfigReader.getConfigValue("wishlist.name"))));
        String savedPlaces = savedWishlistName.getAttribute("content-desc");
        String splittedStr[] = savedPlaces.split("saved")[0].split(" ");
        String savedPlacesStr = splittedStr[splittedStr.length - 1];
        System.out.println(savedPlacesStr);
        int numberOfSavedPlaces = Integer.parseInt(savedPlacesStr);
        return numberOfSavedPlaces>0;
    }

    @Override
    public void clickEditButton(){
        editButton.click();
    }

    @Override
    public void deleteWishlist(){
        removeIcon.click();
        deleteButton.click();
    }
}
