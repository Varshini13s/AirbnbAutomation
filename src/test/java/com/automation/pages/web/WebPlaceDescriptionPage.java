package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.PlaceDescriptionPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebPlaceDescriptionPage extends BasePage implements PlaceDescriptionPage {

    @FindBy(xpath = "//div[@data-testid='card-container']")
    List<WebElement> titleList;

    @FindBy(xpath = "//div[contains(@class,'b9672i7')]/button")
    WebElement showAllAmenitiesButton;

    @FindBy(xpath = "//span[contains(@class,'c1k1xv2h')]//span//span[text()='Show more']")
    WebElement hostDetailsShowMore;

    String XPATH_APPLIED_AMENITIES = "//div[@class='lhg7v4y atm_h0_exct8b dir dir-ltr']/following-sibling::div//div[contains(text(),'%s')]";

    String XPATH_APPLIED_HOST_LANGUAGE = "//span[contains(@class,'t1sthkkh')]//span[contains(text(),'%s')]";

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
