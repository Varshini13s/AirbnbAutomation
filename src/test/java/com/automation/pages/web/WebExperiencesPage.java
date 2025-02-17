package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.ExperiencesPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebExperiencesPage extends BasePage implements ExperiencesPage {
    @FindBy(xpath = "//span[@data-testid='stays-page-heading']")
    WebElement experiencesPageTitle;

    String XPATH_SEARCH_RESULT = "//button[@data-testid='little-search-location']/div[text()='%s']";

    @Override
    public boolean arePlacesDisplayed() {
        System.out.println(getTextUsingJS(experiencesPageTitle));
        WebElement searchResult = driver.findElement(By.xpath(String.format(XPATH_SEARCH_RESULT, ConfigReader.getConfigValue("destination.experiences.name"))));
        return searchResult.isDisplayed();
    }
}
