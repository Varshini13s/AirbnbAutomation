package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.ExperiencesFilterPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidExperiencesFilterPage extends BasePage implements ExperiencesFilterPage {

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.airbnb.android:id/min_price_input']//android.widget.EditText[@resource-id='com.airbnb.android:id/edit_text']")
    WebElement experiencesMinimumPriceInput;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.airbnb.android:id/max_price_input']//android.widget.EditText[@resource-id='com.airbnb.android:id/edit_text']")
    WebElement experiencesMaximumPriceInput;

    @FindBy(id = "com.airbnb.android:id/coordinator_layout")
    WebElement filterLayout;

    @FindBy(xpath = "//android.widget.Button[contains(@text,'Show') and contains(@text,'results')]")
    WebElement resultButton;

    @Override
    public void selectPriceRange(String minimumPrice, String maximumPrice) {
        while (!isDisplayed(experiencesMinimumPriceInput)){
            scrollFilterLayout();
        }
        experiencesMinimumPriceInput.clear();
        experiencesMinimumPriceInput.sendKeys(minimumPrice);
        pause(3000);
        experiencesMaximumPriceInput.clear();
        experiencesMaximumPriceInput.sendKeys(maximumPrice);
        pause(3000);
        resultButton.click();
    }

    public void scrollFilterLayout(){
        int x = filterLayout.getLocation().getX();
        int y = filterLayout.getLocation().getY();
        int width = filterLayout.getSize().getWidth();
        int height = filterLayout.getSize().getHeight();
        scroll(x+width/2,height,x+width/2,y);
    }
}
