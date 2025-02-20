package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.PlaceDescriptionPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

    @FindBy(id = "com.airbnb.android:id/n2_dls_action_footer_title")
    WebElement priceBeforeTaxes;

    @FindBy(id = "com.airbnb.android:id/n2_dls_action_footer_gradient_button")
    WebElement reserveButton;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.airbnb.android:id/price_item_container']//android.widget.TextView[@resource-id='com.airbnb.android:id/price_item_info']")
    List<WebElement> accommodationTaxList;

    @FindBy(xpath = "//android.view.View[@resource-id='com.airbnb.android:id/total_divider']/following-sibling::android.widget.LinearLayout//android.widget.TextView[@resource-id='com.airbnb.android:id/price_item_info']")
    WebElement totalAmount;

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

    @Override
    public boolean isPriceConstant() {
        String priceString = priceBeforeTaxes.getAttribute("content-desc");
        String splittedStr[] = priceString.split("total")[0].split(" ");
        String price = splittedStr[splittedStr.length - 1].replaceAll("[^0-9]", "");
        return price.equals(ConfigReader.getConfigValue("first.place.price"));
    }

    @Override
    public void clickReserveButton() {
        reserveButton.click();
    }

    double accommodationTaxPrice = 0.0;

    @Override
    public boolean verifyTotalPrice() {
        for(int i=0;i< accommodationTaxList.size();i++){
            accommodationTaxPrice += Double.parseDouble(accommodationTaxList.get(i).getText().replaceAll("[^0-9.]", ""));
        }
        double totalPrice = Double.parseDouble(totalAmount.getText().replaceAll("[^0-9.]",""));
        return accommodationTaxPrice == totalPrice;
    }

    public void scrollPageDetailsLayout(){
        int x1 = placeDetailsLayout.getLocation().getX();
        int y1 = placeDetailsLayout.getLocation().getY();
        int width1 = placeDetailsLayout.getSize().getWidth();
        int height1 = placeDetailsLayout.getSize().getHeight();
        scroll(x1 + width1 / 2, height1 - 5, x1 + width1 / 2, y1);
    }
}
