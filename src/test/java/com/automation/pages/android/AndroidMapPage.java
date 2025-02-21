package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.MapPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AndroidMapPage extends BasePage implements MapPage {

    String XPATH_PRICE_MARKER = "//android.view.View[contains(@content-desc,'%s')]";

    String XPATH_PLACE_DETAILS = "//androidx.compose.ui.platform.ComposeView[@resource-id='com.airbnb.android:id/map_card']//android.view.View[contains(@content-desc,'%s')]";

    @Override
    public boolean isLocationPriceMarkerDisplayed() {
        return isDisplayed(String.format(XPATH_PRICE_MARKER, ConfigReader.getConfigValue("place.price")));
    }

    @Override
    public void clickPriceMarker() {
        WebElement priceMarker = driver.findElement(By.xpath(String.format(XPATH_PRICE_MARKER, ConfigReader.getConfigValue("place.price"))));
        priceMarker.click();
    }

    @Override
    public boolean isPlaceDetailDisplayed() {
        return isDisplayed(String.format(XPATH_PLACE_DETAILS,ConfigReader.getConfigValue("place.city.country")));
    }
}
