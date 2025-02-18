package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.ExperiencesPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidExperiencesPage extends BasePage implements ExperiencesPage {

    @FindBy(xpath = "//android.widget.Button[contains(@content-desc,'Filters')]")
    WebElement filtersButton;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.airbnb.android:id/search_feed_container']/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/u4.n/following-sibling::android.view.View")
    WebElement activitiesDescription;

    String XPATH_SEARCH_RESULT = "//android.widget.TextView[@text='%s']";

    @Override
    public boolean areActivitiesDisplayed() {
        WebElement searchResult = driver.findElement(By.xpath(String.format(XPATH_SEARCH_RESULT, ConfigReader.getConfigValue("destination.experiences.name"))));
        return searchResult.isDisplayed();
    }

    @Override
    public void clickOnFiltersButton() {
        filtersButton.click();
    }

    @Override
    public boolean isPriceFilterApplied() {
        String activitiesDescriptionString = activitiesDescription.getAttribute("content-desc");
        System.out.println(activitiesDescriptionString);
        String splittedStr[] = activitiesDescriptionString.split("per person")[0].split(" ");
        String price = splittedStr[splittedStr.length - 1].replaceAll("[^0-9]", "");
        System.out.println(price);
        int minimumPrice = Integer.parseInt(ConfigReader.getConfigValue("minimum.price"));
        int maximumPrice = Integer.parseInt(ConfigReader.getConfigValue("maximum.price"));
        int priceInt = Integer.parseInt(price);
        return minimumPrice < priceInt && priceInt < maximumPrice;
    }

}
