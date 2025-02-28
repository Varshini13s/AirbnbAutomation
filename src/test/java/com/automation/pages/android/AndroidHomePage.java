package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.HomePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileWriter;
import java.io.IOException;

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

    @FindBy(xpath = "//android.widget.TextView[@text='Settings']")
    WebElement settingsOption;

    @FindBy(xpath = "//android.widget.TextView[@text='Explore']")
    WebElement exploreIcon;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.airbnb.android:id/search_feed_container']/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]//android.view.View")
    WebElement placesDescription;

    @FindBy(id = "com.airbnb.android:id/bingo_toolbar_wishlist_button")
    WebElement addToWishlistIcon;

    @FindBy(css = ".android.widget.EditText")
    WebElement wishlistInput;

    @FindBy(id = "com.airbnb.android:id/secondary_button")
    WebElement clearButton;

    @FindBy(id = "com.airbnb.android:id/primary_button")
    WebElement createButton;

    @FindBy(id = "com.airbnb.android:id/bingo_toolbar_nav_button")
    WebElement navigateBackButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Wishlists']")
    WebElement wishlistIcon;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.airbnb.android:id/base_row_text' and @text='Give us feedback']")
    WebElement giveUsFeedbackOption;

    @FindBy(id = "com.airbnb.android:id/map_pill")
    WebElement mapButton;

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
        return searchInputBar.isDisplayed() && wishlistIcon.isDisplayed();
    }

    @Override
    public void clickLoginIcon() {
        loginIcon.click();
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
    public void clickOnAddToWishlistButton() {
        placesDescription.click();
        addToWishlistIcon.click();
    }

    @Override
    public void createNewWishlist(String wishlist) {
        clearButton.click();
        wishlistInput.sendKeys(wishlist);
        createButton.click();
        navigateBackButton.click();
    }

    @Override
    public void clickOnWishlistsIcon() {
        wishlistIcon.click();
    }

    @Override
    public void clickLoginOption() {
        loginButton.click();
    }

    @Override
    public void clickProfileIcon() {
        profileIcon.click();
    }

    @Override
    public boolean isLoginSuccessful() {
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

    @Override
    public void clickOnSettings(){
        settingsOption.click();
    }

    @Override
    public void clickExploreIcon(){
        exploreIcon.click();
    }

    @Override
    public boolean isCurrencyApplied(){
        String placesDescriptionString = placesDescription.getAttribute("content-desc");
        String currencySymbol =placesDescriptionString.replaceAll("[^\\p{Sc}]","");

        return currencySymbol.equals(ConfigReader.getConfigValue("currency.symbol"));
    }

    @Override
    public void clickFeedbackOption() {
        while (!isDisplayed(giveUsFeedbackOption)){
            int x = profileLayout.getLocation().getX();
            int y = profileLayout.getLocation().getY();
            int height = profileLayout.getSize().getHeight();
            int width = profileLayout.getSize().getWidth();
            scroll(x+width/2,height,x+width/2,y);
        }
        giveUsFeedbackOption.click();
    }

    @Override
    public void getFirstPlaceDetails() {
        String placesDescriptionString = placesDescription.getAttribute("content-desc");
        String splittedStr[] = placesDescriptionString.split("per night")[0].split(" ");
        String price = splittedStr[splittedStr.length - 1].replaceAll("[^0-9,]", "");
        ConfigReader.setConfigValue("place.price",price);
        System.out.println(price);
        String cityCountryPattern = "[A-Za-z]+,\\s[A-Za-z]+";
        String cityCountry = placesDescriptionString.replaceAll(".*?(" + cityCountryPattern + ").*", "$1").trim();
        ConfigReader.setConfigValue("place.city.country",cityCountry);
        System.out.println(cityCountry);
    }

    @Override
    public void clickMapButton() {
        mapButton.click();
    }


}
