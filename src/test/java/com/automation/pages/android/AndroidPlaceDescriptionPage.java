package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.PlaceDescriptionPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidPlaceDescriptionPage extends BasePage implements PlaceDescriptionPage {

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.airbnb.android:id/search_feed_container']/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[3]")
    WebElement placesLayout;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='Go to Host profile']")
    WebElement hostDetailsShowMore;

    @FindBy(id = "com.airbnb.android:id/recycler_view")
    WebElement placeDetailsLayout;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'amenities')]")
    WebElement showAllAmenitiesButton;

    @FindBy(xpath = "//android.widget.ScrollView")
    WebElement appliedAmenitiesLayout;

    String XPATH_APPLIED_HOST_LANGUAGE = "//android.widget.TextView[contains(@text,'%s')]";

    String XPATH_APPLIED_AMENITIES = "//android.widget.TextView[@text='%s']";

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

    public void scrollPageDetailsLayout(){
        int x1 = placeDetailsLayout.getLocation().getX();
        int y1 = placeDetailsLayout.getLocation().getY();
        int width1 = placeDetailsLayout.getSize().getWidth();
        int height1 = placeDetailsLayout.getSize().getHeight();
        scroll(x1 + width1 / 2, height1 - 5, x1 + width1 / 2, y1);
    }
}
