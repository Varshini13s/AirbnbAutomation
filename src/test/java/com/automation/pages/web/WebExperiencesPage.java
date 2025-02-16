package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.ExperiencesPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebExperiencesPage extends BasePage implements ExperiencesPage {
    @FindBy(xpath = "//span[@data-testid='stays-page-heading']")
    WebElement staysPageTitle;

    String XPATH_SEARCH_RESULT = "//h1/span[@data-testid='stays-page-heading']";

    @Override
    public boolean arePlacesDisplayed() {
        System.out.println(getTextUsingJS(staysPageTitle));
        WebElement searchResult = driver.findElement(By.xpath(String.format(XPATH_SEARCH_RESULT, ConfigReader.getConfigValue("destination.experiences.name"))));
        return searchResult.isDisplayed();
    }
}
