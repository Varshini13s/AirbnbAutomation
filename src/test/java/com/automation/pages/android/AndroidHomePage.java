package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.HomePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

public class AndroidHomePage extends BasePage implements HomePage {

    @FindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    WebElement doNotAllowButton;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Close']")
    WebElement closeButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.airbnb.android:id/navigation_bar_item_small_label_view' and @text='Log In']")
    WebElement loginIcon;

    @FindBy(id = "com.airbnb.android:id/gradient_button_row_button")
    WebElement loginButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Show profile']")
    WebElement showProfileText;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.airbnb.android:id/navigation_bar_item_small_label_view' and @text='Profile']")
    WebElement profileIcon;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.airbnb.android:id/base_row_text' and @text='Log out']")
    WebElement logoutOption;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.airbnb.android:id/content_container']")
    WebElement profileLayout;

    @FindBy(id = "com.airbnb.android:id/n2_dls_action_footer_gradient_button")
    WebElement logoutButton;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Close']")
    WebElement logoutCloseButton;

    @FindBy(id = "com.airbnb.android:id/search_input_bar")
    WebElement searchInputBar;

    @FindBy(xpath = "//android.widget.TextView[@text='Homes' or @text='Stays']")
    WebElement staysButton;

    @FindBy(css = ".android.widget.EditText")
    WebElement destinationInput;

    @FindBy(xpath = "//android.widget.TextView[@text='Next']")
    WebElement nextButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Search']")
    WebElement searchButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Experiences']")
    WebElement experiencesButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Choose dates']")
    WebElement chooseDateButton;

    String XPATH_DESTINATION_OPTION = "//android.widget.TextView[contains(@text,'%s')]";

    String XPATH_INCREASE_BUTTON = "//android.widget.TextView[@text='%s']/..//following-sibling::android.widget.Button[@content-desc='increment']";

    @Override
    public void openApplication() {
        if(isDisplayed(doNotAllowButton)){
            doNotAllowButton.click();
        }
        if(isDisplayed(closeButton)){
            closeButton.click();
        }

    }

    @Override
    public boolean isHomePageDisplayed() {
        return loginIcon.isDisplayed() && searchInputBar.isDisplayed();
    }

    @Override
    public boolean isStaysButtonSelected() {
        searchInputBar.click();
        return staysButton.getAttribute("clickable").equals("false");
    }

    @Override
    public void selectDestination(String destinationName) {
        destinationInput.click();
        destinationInput.sendKeys(destinationName);
        pause(2000);
        WebElement destinationOption = driver.findElement(By.xpath(String.format(XPATH_DESTINATION_OPTION,destinationName)));
        destinationOption.click();
    }

    @Override
    public void selectDates(String checkinDate, String checkoutDate) {
        if(isDisplayed(chooseDateButton)){
            chooseDateButton.click();
        }
        pause(5000);
        String pageSource = driver.getPageSource();
        try (FileWriter fileWriter = new FileWriter("pageSource1.html")) {
            fileWriter.write(pageSource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //pause(8000);
        nextButton.click();
    }

    @Override
    public void selectGuests() {
        selectGuestNumber(ConfigReader.getConfigValue("adults.count"),"Adults");
        selectGuestNumber(ConfigReader.getConfigValue("children.count"),"Children");
        selectGuestNumber(ConfigReader.getConfigValue("infants.count"),"Infants");
    }

    public void selectGuestNumber(String person, String category){
        int personCount = Integer.parseInt(person);
        WebElement increaseButton = driver.findElement(By.xpath(String.format(XPATH_INCREASE_BUTTON,category)));
        for (int i=0;i<personCount;i++){
            increaseButton.click();
        }
    }

    @Override
    public void clickOnSearchButton() {
        searchButton.click();
    }

    @Override
    public void clickOnExperiencesButton() {
        searchInputBar.click();
        experiencesButton.click();
    }

    @Override
    public boolean isExperiencesButtonSelected() {
        return experiencesButton.getAttribute("clickable").equals("false");
    }

    @Override
    public void clickProfileIcon() {
        loginIcon.click();
    }

    @Override
    public void clickLoginOption() {
        loginButton.click();
    }

    @Override
    public boolean isLoginSuccessful() {
        profileIcon.click();
        return showProfileText.isDisplayed();
    }

    @Override
    public void clickLogoutOption() {
        while (!isDisplayed(logoutOption)){
            int x = profileLayout.getLocation().getX();
            int y = profileLayout.getLocation().getY();
            int height = profileLayout.getSize().getHeight();
            int width = profileLayout.getSize().getWidth();
            scroll(x+width/2,height,x+width/2,y);
        }
        logoutOption.click();
        logoutButton.click();
        if(isDisplayed(logoutCloseButton)) {
            logoutCloseButton.click();
        }
    }

    @Override
    public boolean isLogoutSuccessful() {
        return loginIcon.isDisplayed();
    }
}
