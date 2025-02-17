package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.ExperiencesPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AndroidExperiencesPage extends BasePage implements ExperiencesPage {

    String XPATH_SEARCH_RESULT = "//android.widget.TextView[@text='%s']";

    @Override
    public boolean arePlacesDisplayed() {
        WebElement searchResult = driver.findElement(By.xpath(String.format(XPATH_SEARCH_RESULT, ConfigReader.getConfigValue("destination.experiences.name"))));
        return searchResult.isDisplayed();
    }
}
