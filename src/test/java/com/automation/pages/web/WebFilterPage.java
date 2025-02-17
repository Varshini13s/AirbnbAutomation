package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.FilterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebFilterPage extends BasePage implements FilterPage {

    @FindBy(xpath = "//input[@id='price_filter_min']")
    WebElement minimumPriceInput;

    @FindBy(xpath = "//input[@id='price_filter_max']")
    WebElement maximumPriceInput;

    @FindBy(xpath = "//div[@class='p13966et atm_7l_1p8m8iw dir dir-ltr']//a")
    WebElement resultButton;

    @FindBy(xpath = "//button[@aria-label='Show more amenities']")
    WebElement showMoreOptionsButton;

    @FindBy(xpath = "//div[@id='FILTER_SECTION_CONTAINER:HOST_LANGUAGE']")
    WebElement hostLanguageContainer;

    String XPATH_AMENITY_OPTION = "//span[@class='m12i7xxa atm_9s_1ulexfb dir dir-ltr' and text()='%s']";

    String XPATH_HOST_LANGUAGE_OPTION = "//div[@id='filter-item-host_languages-ur-row-title' and text()='%s']";

    @Override
    public void selectPriceRange(String minimumPrice, String maximumPrice) {
        actions.moveToElement(minimumPriceInput).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        actions.sendKeys(Keys.BACK_SPACE).perform();
        minimumPriceInput.sendKeys(minimumPrice);
        actions.moveToElement(maximumPriceInput).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        actions.sendKeys(Keys.BACK_SPACE).perform();
        maximumPriceInput.sendKeys(maximumPrice);
        minimumPriceInput.click();
    }

    @Override
    public void selectAmenities(String amenitiesOption) {
        showMoreOptionsButton.click();
        String[] items = amenitiesOption.split(",");
        for (String item : items) {
            WebElement amenityOption = driver.findElement(By.xpath(String.format(XPATH_AMENITY_OPTION,item)));
            amenityOption.click();
        }
    }

    @Override
    public void selectHostLanguage(String hostLanguage) {
        hostLanguageContainer.click();
        String[] languages = hostLanguage.split(",");
        for (String language : languages) {
            WebElement hostLanguageOption = driver.findElement(By.xpath(String.format(XPATH_HOST_LANGUAGE_OPTION,languages)));
            hostLanguageOption.click();
        }
    }

    @Override
    public void getFilterResult() {
        pause(2000);
        System.out.println(resultButton.getText());
        resultButton.click();
    }
}
