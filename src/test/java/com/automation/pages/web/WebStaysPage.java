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

    @FindBy(xpath = "//div[@data-testid='card-container']")
    List<WebElement> titleList;

    @FindBy(xpath = "//div[contains(@class,'b9672i7')]/button")
    WebElement showAllAmenitiesButton;

    @FindBy(xpath = "//span[contains(@class,'c1k1xv2h')]//span//span[text()='Show more']")
    WebElement hostDetailsShowMore;

    String XPATH_APPLIED_AMENITIES = "//div[@class='lhg7v4y atm_h0_exct8b dir dir-ltr']/following-sibling::div//div[contains(text(),'%s')]";

    String XPATH_APPLIED_HOST_LANGUAGE = "//span[contains(@class,'t1sthkkh')]//span[contains(text(),'%s')]";

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
            int price = Integer.parseInt(priceList.get(i).getText().replace("₹","").replace(",","").trim());
            if(! (minimumPrice < price && price < maximumPrice)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isAmenitiesFilterApplied() {
        pause(2000);
        for (int i=0;i< titleList.size();i++){
            titleList.get(i).click();
            moveToAnotherTab();
            showAllAmenitiesButton.click();
            String[] items = ConfigReader.getConfigValue("amenities.option").split(",");
            for (String item : items) {
                WebElement appliedAmenities = driver.findElement(By.xpath(String.format(XPATH_APPLIED_AMENITIES,item)));
                if(!isDisplayed(appliedAmenities)){
                    return false;
                }
            }
            moveToCurrentTab();
        }
        return true;
    }

    @Override
    public boolean isHostLanguageFilterApplied() {
        pause(2000);
        for (int i=0;i< titleList.size();i++){
            titleList.get(i).click();
            moveToAnotherTab();
            hostDetailsShowMore.click();
            String[] languages = ConfigReader.getConfigValue("host.language").split(",");
            for (String language : languages) {
                WebElement appliedHostLanguage = driver.findElement(By.xpath(String.format(XPATH_APPLIED_HOST_LANGUAGE,language)));
                if(!isDisplayed(appliedHostLanguage)){
                    return false;
                }
            }
            moveToCurrentTab();
        }
        return true;
    }

}
