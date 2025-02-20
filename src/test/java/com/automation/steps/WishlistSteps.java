package com.automation.steps;

import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WishlistSteps extends BaseSteps {

    @Then("verify wishlist with name {string} is displayed")
    public void verifyWishListIsDisplayed(String wishlistName) {
        Assert.assertTrue(wishlistPage.isWishlistNameDisplayed(ConfigReader.getConfigValue(wishlistName)));
        Assert.assertTrue(wishlistPage.isPlaceAddedToWishlist());
    }

    @When("user click on wishlist {string}")
    public void userClickOnWishlist(String wishlistName) {
        wishlistPage.clickOnWishlist(ConfigReader.getConfigValue(wishlistName));
    }

    @And("user deselect wishlist button on the image")
    public void userDeselectWishlistButtonOnTheImage() {
        wishlistPage.deselectWishlistButton();
    }

    @Then("verify the place is removed from the wishlist")
    public void verifyThePlaceIsRemovedFromTheWishlist() {
        Assert.assertTrue(wishlistPage.isPlaceRemovedFromWishlist());
    }

    @When("user click on edit button")
    public void userClickOnEditButton() {
        wishlistPage.clickEditButton();
    }

    @And("user delete wishlist")
    public void userDeleteWishlist() {
        wishlistPage.deleteWishlist();
    }

    @Then("verify the saved wishlist {string} is removed")
    public void verifyTheSavedWishlistIsRemoved(String wishlistName) {
        Assert.assertFalse(wishlistPage.isWishlistNameDisplayed(ConfigReader.getConfigValue(wishlistName)));
    }
}
