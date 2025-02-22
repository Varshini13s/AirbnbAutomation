package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.MapPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebMapPage extends BasePage implements MapPage {

    String XPATH_PRICE_MARKER = "//span[contains(text(),'%s')]/ancestor::button";

    String XPATH_PLACE_DETAILS = "//div[@data-testid='listing-card-title' and text()='%s']";

    @Override
    public boolean isLocationPriceMarkerDisplayed() {
        return isDisplayed(String.format(XPATH_PRICE_MARKER, ConfigReader.getConfigValue("place.price")));
    }

    @Override
    public void clickPriceMarker() {
        WebElement priceMarker = driver.findElement(By.xpath(String.format(XPATH_PRICE_MARKER, ConfigReader.getConfigValue("place.price"))));
        actions.moveToElement(priceMarker).click().perform();
    }

    @Override
    public boolean isPlaceDetailDisplayed() {
        return isDisplayed(String.format(XPATH_PLACE_DETAILS,ConfigReader.getConfigValue("place.city.country")));
    }
}
