package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.StaysPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebStaysPage extends BasePage implements StaysPage {

    @FindBy(xpath = "//span[@data-testid='stays-page-heading']")
    WebElement staysPageTitle;

    @FindBy(xpath = "//button[@data-testid='category-bar-filter-button']")
    WebElement filterButton;

    @FindBy(css = "._11jcbg2")
    List<WebElement> priceList;

    String XPATH_SEARCH_RESULT = "//button[@data-testid='little-search-location']/div[text()='%s']";

    @Override
    public boolean arePlacesDisplayed() {
        pause(2000);
        System.out.println(getTextUsingJS(staysPageTitle));
        WebElement searchResult = driver.findElement(By.xpath(String.format(XPATH_SEARCH_RESULT, ConfigReader.getConfigValue("destination.stays.name"))));
        return searchResult.isDisplayed();
    }

    @Override
    public void clickFilterButton() {
        filterButton.click();
    }

    @Override
    public boolean isPriceFilterApplied() {
        pause(2000);
        System.out.println(getTextUsingJS(staysPageTitle));
        int minimumPrice = Integer.parseInt(ConfigReader.getConfigValue("minimum.price"));
        int maximumPrice = Integer.parseInt(ConfigReader.getConfigValue("maximum.price"));
        for(int i=0;i< priceList.size();i++){
            int price = Integer.parseInt(priceList.get(i).getText().replaceAll("[^0-9]",""));
            if(! (minimumPrice < price && price < maximumPrice)){
                return false;
            }
        }
        return true;
    }
}
