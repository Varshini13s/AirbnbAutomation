package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.FilterPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidFilterPage extends BasePage implements FilterPage {

    @FindBy(xpath = "//android.widget.EditText[@content-desc='Minimum']")
    WebElement minimumPriceInput;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='Maximum']")
    WebElement maximumPriceInput;

    @FindBy(xpath = "//android.view.View[@content-desc='Filters']/android.view.View/android.view.View/android.view.View[1]")
    WebElement filterLayout;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Show') and contains(@text,'places')]")
    WebElement resultButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Show more']")
    WebElement showMoreOptionsButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Host language']")
    WebElement hostLanguageFilter;

    String XPATH_AMENITY_OPTION = "//android.widget.TextView[@text='%s']";

    String XPATH_HOST_LANGUAGE_OPTION = "//android.widget.TextView[@text='%s']";

    @Override
    public void selectPriceRange(String minimumPrice, String maximumPrice) {
        while (!isDisplayed(minimumPriceInput)){
            scrollFilterLayout();
        }
        minimumPriceInput.clear();
        minimumPriceInput.sendKeys(minimumPrice);
        maximumPriceInput.clear();
        maximumPriceInput.sendKeys(maximumPrice);
    }

    @Override
    public void selectAmenities(String amenitiesOption) {
        while (!isDisplayed(showMoreOptionsButton)){
            scrollFilterLayout();
        }
        showMoreOptionsButton.click();
        String[] items = amenitiesOption.split(",");
        for (String item : items) {
            while (!isDisplayed(String.format(XPATH_AMENITY_OPTION,item))){
                scrollFilterLayout();
            }
            WebElement amenityOption = driver.findElement(By.xpath(String.format(XPATH_AMENITY_OPTION,item)));
            amenityOption.click();
        }
    }

    @Override
    public void selectHostLanguage(String hostLanguage) {
        while (!isDisplayed(hostLanguageFilter)){
            scrollFilterLayout();
        }
        hostLanguageFilter.click();
        String[] items = hostLanguage.split(",");
        for (String item : items) {
            while (!isDisplayed(String.format(XPATH_HOST_LANGUAGE_OPTION,item))){
                scrollFilterLayout();
            }
            WebElement hostLanguageOption = driver.findElement(By.xpath(String.format(XPATH_HOST_LANGUAGE_OPTION,item)));
            hostLanguageOption.click();
        }

    }

    @Override
    public void getFilterResult() {
        pause(2000);
        System.out.println(resultButton.getText());
        ConfigReader.setConfigValue("filterResultText",resultButton.getText().replace("Show ",""));
        resultButton.click();
    }

    public void scrollFilterLayout(){
        int x = filterLayout.getLocation().getX();
        int y = filterLayout.getLocation().getY();
        int width = filterLayout.getSize().getWidth();
        int height = filterLayout.getSize().getHeight();
        scroll(x+width/2,height,x+width/2,y);
    }

}
