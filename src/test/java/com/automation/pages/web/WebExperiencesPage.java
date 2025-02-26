package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.ExperiencesPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebExperiencesPage extends BasePage implements ExperiencesPage {

    @FindBy(xpath = "//span[@data-testid='stays-page-heading']")
    WebElement experiencesPageTitle;

    @FindBy(xpath = "//button[@aria-label='Filters']")
    WebElement filtersButton;

    @FindBy(id = "menuItemButton-Price")
    WebElement priceFilterButton;

    @FindBy(css = "._hb913q")
    List<WebElement> priceList;

    String XPATH_APPLIED_ACTIVITY_TYPE = "//div[@class='delcd7d atm_j3_1risgsc dir dir-ltr']//button[contains(text(),'%s')]";

    String XPATH_SEARCH_RESULT = "//button[@data-testid='little-search-location']/div[text()='%s']";

    @Override
    public boolean areActivitiesDisplayed() {
        System.out.println(getTextUsingJS(experiencesPageTitle));
        WebElement searchResult = driver.findElement(By.xpath(String.format(XPATH_SEARCH_RESULT, ConfigReader.getConfigValue("destination.experiences.name"))));
        return searchResult.isDisplayed();
    }

    @Override
    public void clickOnFiltersButton() {
        filtersButton.click();
    }

    @Override
    public void clickOnPriceButton() {
        priceFilterButton.click();
    }

    @Override
    public boolean isPriceFilterApplied() {
        pause(2000);
        System.out.println(getTextUsingJS(experiencesPageTitle));
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

    @Override
    public boolean isActivityTypeFilterApplied(){
        String[] items = ConfigReader.getConfigValue("activity.type").split(",");
        for (String item : items) {
            WebElement appliedActivityType = driver.findElement(By.xpath(String.format(XPATH_APPLIED_ACTIVITY_TYPE,item)));
            if(!appliedActivityType.getAttribute("aria-checked").equals("true")){
                return false;
            }
        }
        return true;
    }

}
