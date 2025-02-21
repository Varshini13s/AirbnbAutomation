package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.MapPage;

public class WebMapPage extends BasePage implements MapPage {
    @Override
    public boolean isLocationPriceMarkerDisplayed() {
        return false;
    }

    @Override
    public void clickPriceMarker() {

    }

    @Override
    public boolean isPlaceDetailDisplayed() {
        return false;
    }
}
