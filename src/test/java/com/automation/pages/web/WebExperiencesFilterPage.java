package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.ExperiencesFilterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebExperiencesFilterPage extends BasePage implements ExperiencesFilterPage {

    @FindBy(xpath = "//input[@id='price_filter_min']")
    WebElement minimumPriceInput;

    @FindBy(xpath = "//input[@id='price_filter_max']")
    WebElement maximumPriceInput;

    @FindBy(xpath = "//button[@data-testid='filter-panel-save-button']")
    WebElement saveButton;

    @FindBy(xpath = "//button[@aria-label='Show more activity types']")
    WebElement showMoreActivityButton;

    @FindBy(xpath = "//a[contains(text(),'Show') and contains(text(),'results')]")
    WebElement resultButton;

    String XPATH_ACTIVITY_TYPE_OPTION = "//div[contains(@id,'filter-item-kg') and contains(text(),'%s')]";

    @Override
    public void selectPriceRange(String minimumPrice, String maximumPrice) {
        minimumPriceInput.click();
        actions.moveToElement(minimumPriceInput).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        actions.sendKeys(Keys.BACK_SPACE).perform();
        minimumPriceInput.sendKeys(minimumPrice);
        actions.moveToElement(maximumPriceInput).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        actions.sendKeys(Keys.BACK_SPACE).perform();
        maximumPriceInput.sendKeys(maximumPrice);
        saveButton.click();
    }

    @Override
    public void selectActivityType(String activityType){
        showMoreActivityButton.click();
        String[] items = activityType.split(",");
        for (String item : items) {
            WebElement activityTypeOption = driver.findElement(By.xpath(String.format(XPATH_ACTIVITY_TYPE_OPTION,item)));
            activityTypeOption.click();
            pause(1000);
        }
        resultButton.click();
    }

}
