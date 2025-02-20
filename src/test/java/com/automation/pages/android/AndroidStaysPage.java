package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.StaysPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidStaysPage extends BasePage implements StaysPage {

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.airbnb.android:id/search_feed_container']//android.widget.TextView")
    WebElement staysPageTitle;

    @FindBy(xpath = "//android.widget.Button[contains(@content-desc,'Filters')]")
    WebElement filterButton;

    @FindBy(id = "com.airbnb.android:id/search_feed_container")
    WebElement staysPageContainer;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.airbnb.android:id/search_feed_container']/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[3]//android.view.View")
    WebElement placesDescription;

    @FindBy(xpath = "//android.widget.TextView[@text='Display total price']/../following-sibling::android.view.View[1]")
    WebElement displayTotalPriceButton;

    String XPATH_SEARCH_RESULT = "//android.widget.TextView[@text='%s']";

    @Override
    public boolean arePlacesDisplayed() {
        pause(2000);
        System.out.println(staysPageTitle.getText());
        WebElement searchResult = driver.findElement(By.xpath(String.format(XPATH_SEARCH_RESULT, ConfigReader.getConfigValue("destination.stays.name"))));
        return searchResult.isDisplayed();
    }

    @Override
    public void clickFilterButton() {
        filterButton.click();
    }

    @Override
    public boolean isPriceFilterApplied() {
        String placesDescriptionString = placesDescription.getAttribute("content-desc");
        System.out.println(placesDescriptionString);
        String splittedStr[] = placesDescriptionString.split("per night")[0].split(" ");
        String price = splittedStr[splittedStr.length - 1].replaceAll("[^0-9]", "");
        System.out.println(price);
        int minimumPrice = Integer.parseInt(ConfigReader.getConfigValue("minimum.price"));
        int maximumPrice = Integer.parseInt(ConfigReader.getConfigValue("maximum.price"));
        int priceInt = Integer.parseInt(price);
        return minimumPrice < priceInt && priceInt < maximumPrice;
    }

    @Override
    public void scrollOverMap() {
        int x = staysPageContainer.getLocation().getX();
        int y = staysPageContainer.getLocation().getY();
        int width = staysPageContainer.getSize().getWidth();
        int height = staysPageContainer.getSize().getHeight();
        scroll(x + width / 2, y, x + width / 2, 0);
    }

    @Override
    public void enableDisplayTotalPrice() {
        scrollOverMap();
        displayTotalPriceButton.click();
        pause(3000);
    }

    @Override
    public void getPrice() {
        String placesDescriptionString = placesDescription.getAttribute("content-desc");
        String splittedStr[] = placesDescriptionString.split("total")[0].split(" ");
        String price = splittedStr[splittedStr.length - 1].replaceAll("[^0-9]", "");
        ConfigReader.setConfigValue("first.place.price",price);
    }

    @Override
    public void clickFirstPlace() {
        placesDescription.click();
    }
}

