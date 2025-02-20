package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.CurrencyPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidCurrencyPage extends BasePage implements CurrencyPage {

    @FindBy(xpath = "//android.widget.ScrollView")
    WebElement currencyLayout;

    String XPATH_CURRENCY_NAME = "//android.widget.TextView[contains(@text,'%s')]";

    @Override
    public void selectCurrency(String currency) {
        while (!isDisplayed(String.format(XPATH_CURRENCY_NAME,currency))){
            int x = currencyLayout.getLocation().getX();
            int y = currencyLayout.getLocation().getY();
            int width = currencyLayout.getSize().getWidth();
            int height = currencyLayout.getSize().getHeight();
            scroll(x+width/2,height,x+width/2,y);
        }
        WebElement currencyName = driver.findElement(By.xpath(String.format(XPATH_CURRENCY_NAME,currency)));
        String currencySymbol = currencyName.getText().replaceAll("[^\\p{Sc}]","");
        System.out.println(currencySymbol);
        ConfigReader.setConfigValue("currency.symbol",currencySymbol);
        currencyName.click();
    }

}
