package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.HomePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class WebHomePage extends BasePage implements HomePage {

    @FindBy(xpath = "//button[@aria-label='Main navigation menu']")
    WebElement userProfileIcon;

    @FindBy(xpath = "//div[text()='Log in']")
    WebElement loginOption;

    @FindBy(xpath = "//div[text()='Log out']")
    WebElement logoutOption;

    @FindBy(xpath = "//div[text()='Account']")
    WebElement accountOption;

    @FindBy(xpath = "//button[@data-testid='structured-search-input-search-button']")
    WebElement searchButton;

    @FindBy(xpath = "//button[@id='search-block-tab-STAYS']")
    WebElement staysButton;

    @FindBy(id = "bigsearch-query-location-input")
    WebElement destinationInput;

    String XPATH_DESTINATION_OPTION = "//b[@class='b1viecjw atm_cs_10d11i2 dir dir-ltr' and contains(text(),'%s')]";

    @FindBy(xpath = "//div[@data-testid='structured-search-input-field-dates-panel']//h2")
    WebElement monthAndYear;

    @FindBy(xpath = "//button[@aria-label='Move forward to change to the next month.']")
    WebElement nextBtn;

    @FindBy(xpath = "//div[@data-testid='structured-search-input-field-guests-button']")
    WebElement addGuestsInput;

    @FindBy(xpath = "//button[@id='search-block-tab-EXPERIENCES']")
    WebElement experiencesButton;

    String XPATH_DATE_VALUE = "//button[contains(@aria-label,'%s,')]";

    String XPATH_INCREASE_BUTTON = "//button[@data-testid='stepper-%s-increase-button']";

    public void openApplication() {
        driver.get(ConfigReader.getConfigValue("application.url"));
    }

    @Override
    public boolean isHomePageDisplayed() {
        return userProfileIcon.isDisplayed() && searchButton.isDisplayed();
    }

    public void clickProfileIcon() {
        userProfileIcon.click();
    }

    public void clickLoginOption() {
        loginOption.click();
    }

    public boolean isLoginSuccessful() {
        userProfileIcon.click();
        return logoutOption.isDisplayed() && accountOption.isDisplayed();
    }

    @Override
    public void clickLogoutOption() {
        logoutOption.click();
    }

    @Override
    public boolean isLogoutSuccessful() {
        pause(2000);
        userProfileIcon.click();
        return loginOption.isDisplayed();
    }

    @Override
    public boolean isStaysButtonSelected() {
        return staysButton.getAttribute("aria-selected").equals("true");
    }

    @Override
    public void selectDestination(String destinationName) {
//        waitForElementClickable(destinationInput);
        destinationInput.sendKeys(destinationName);
        WebElement destinationOption = driver.findElement(By.xpath(String.format(XPATH_DESTINATION_OPTION,destinationName)));
//        waitForElementVisible(destinationOption);
        destinationOption.click();
    }

    @Override
    public void selectDates(String checkinDate, String checkoutDate) {
        enterDate(checkinDate);
        enterDate(checkoutDate);
    }

    public void enterDate(String date) {
        String expMonthYear = getFormattedDate("MMMM yyyy", date, "dd/MM/yyyy");
        String actMonthYear = monthAndYear.getText();
        while (!expMonthYear.equalsIgnoreCase(actMonthYear)) {
            System.out.println(expMonthYear);
            System.out.println(actMonthYear);
            nextBtn.click();
            pause(2000);
            actMonthYear = monthAndYear.getText();
        }

        String dateValue = getFormattedDate("d", date, "dd/MM/yyyy");
        WebElement dateElement = driver.findElement(By.xpath(String.format(XPATH_DATE_VALUE, dateValue)));
        dateElement.click();
    }

    @Override
    public void selectGuests() {
        addGuestsInput.click();
        selectGuestNumber(ConfigReader.getConfigValue("adults.count"), "adults");
        selectGuestNumber(ConfigReader.getConfigValue("children.count"), "children");
        selectGuestNumber(ConfigReader.getConfigValue("infants.count"), "infants");
    }

    @Override
    public void clickOnSearchButton() {
        searchButton.click();
    }

    public void selectGuestNumber(String person, String category) {
        int personCount = Integer.parseInt(person);
        WebElement increaseButton = driver.findElement(By.xpath(String.format(XPATH_INCREASE_BUTTON, category)));
        for (int i = 0; i < personCount; i++) {
            increaseButton.click();
        }
    }

    @Override
    public void clickOnExperiencesButton() {
        experiencesButton.click();
    }

    @Override
    public boolean isExperiencesButtonSelected() {
        return experiencesButton.getAttribute("aria-selected").equals("true");
    }

}
