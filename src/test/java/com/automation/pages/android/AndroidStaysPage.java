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

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.airbnb.android:id/search_feed_container']/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]")
    WebElement placesLayout;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='Go to Host profile']")
    WebElement hostDetailsShowMore;

    @FindBy(id = "com.airbnb.android:id/recycler_view")
    WebElement placeDetailsLayout;

    @FindBy(xpath = "//android.widget.TextView[@text='Display total price']")
    WebElement displayTotalPriceText;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'amenities')]")
    WebElement showAllAmenitiesButton;

    @FindBy(xpath = "//android.widget.ScrollView")
    WebElement appliedAmenitiesLayout;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.airbnb.android:id/search_feed_container']/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]//android.view.View")
    WebElement placesDescription;


    String XPATH_SEARCH_RESULT = "//android.widget.TextView[@text='%s']";

    String XPATH_APPLIED_HOST_LANGUAGE = "//android.widget.TextView[contains(@text,'%s')]";

    String XPATH_APPLIED_AMENITIES = "//android.widget.TextView[@text='%s']";

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
    public boolean isAmenitiesFilterApplied() {
        placesLayout.click();
        while (!isDisplayed(showAllAmenitiesButton)) {
            scrollPageDetailsLayout();
        }
        showAllAmenitiesButton.click();
        String[] items = ConfigReader.getConfigValue("amenities.option").split(",");
        for (String item : items) {
            while (!isDisplayed(String.format(XPATH_APPLIED_AMENITIES, item))) {
                int x1 = appliedAmenitiesLayout.getLocation().getX();
                int y1 = appliedAmenitiesLayout.getLocation().getY();
                int width1 = appliedAmenitiesLayout.getSize().getWidth();
                int height1 = appliedAmenitiesLayout.getSize().getHeight();
                scroll(x1 + width1 / 2, height1, x1 + width1 / 2, y1);
            }
        }
        return true;
    }

    @Override
    public boolean isHostLanguageFilterApplied() {
        System.out.println(isDisplayed(displayTotalPriceText));
        placesLayout.click();
        while (!isDisplayed(hostDetailsShowMore)) {
            scrollPageDetailsLayout();
        }
        hostDetailsShowMore.click();
        String[] languages = ConfigReader.getConfigValue("host.language").split(",");
        for (String language : languages) {
            WebElement appliedHostLanguage = driver.findElement(By.xpath(String.format(XPATH_APPLIED_HOST_LANGUAGE, language)));
            if (!isDisplayed(appliedHostLanguage)) {
                return false;
            }
        }
        return true;

    }

    @Override
    public void scrollOverMap() {
        int x = staysPageContainer.getLocation().getX();
        int y = staysPageContainer.getLocation().getY();
        int width = staysPageContainer.getSize().getWidth();
        int height = staysPageContainer.getSize().getHeight();
        scroll(x + width / 2, y, x + width / 2, 0);
    }

    public void scrollPageDetailsLayout(){
        int x1 = placeDetailsLayout.getLocation().getX();
        int y1 = placeDetailsLayout.getLocation().getY();
        int width1 = placeDetailsLayout.getSize().getWidth();
        int height1 = placeDetailsLayout.getSize().getHeight();
        scroll(x1 + width1 / 2, height1 - 5, x1 + width1 / 2, y1);
    }
}

