package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.StaysPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Stack;

public class AndroidStaysPage extends BasePage implements StaysPage {

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.airbnb.android:id/search_feed_container']//android.widget.TextView")
    WebElement staysPageTitle;

    String XPATH_SEARCH_RESULT = "//android.widget.TextView[@text='%s']";

    @Override
    public boolean arePlacesDisplayed() {
        System.out.println(staysPageTitle.getText());
        WebElement searchResult = driver.findElement(By.xpath(String.format(XPATH_SEARCH_RESULT, ConfigReader.getConfigValue("destination.stays.name"))));
        return searchResult.isDisplayed();
    }

    @Override
    public void clickFilterButton() {

    }

    @Override
    public boolean isPriceFilterApplied() {
        return false;
    }

    @Override
    public boolean isAmenitiesFilterApplied() {
        return false;
    }

    @Override
    public boolean isHostLanguageFilterApplied() {
        return false;
    }
}
