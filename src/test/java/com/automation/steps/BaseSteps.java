package com.automation.steps;

import com.automation.pages.android.*;
import com.automation.pages.ui.*;
import com.automation.pages.web.*;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en_scouse.An;

public class BaseSteps {

    HomePage homePage;
    LoginPage loginPage;
    StaysPage staysPage;
    ExperiencesPage experiencesPage;
    StaysFilterPage staysFilterPage;
    ExperiencesFilterPage experiencesFilterPage;
    WishlistPage wishlistPage;
    SettingsPage settingsPage;
    CurrencyPage currencyPage;
    CurrencyLanguagePage currencyLanguagePage;
    FeedbackPage feedbackPage;
    PlaceDescriptionPage placeDescriptionPage;

    public BaseSteps(){
        if(ConfigReader.getConfigValue("platform").equals("web")){
            homePage = new WebHomePage();
            loginPage = new WebLoginPage();
            staysPage = new WebStaysPage();
            experiencesPage = new WebExperiencesPage();
            staysFilterPage = new WebStaysFilterPage();
            experiencesFilterPage = new WebExperiencesFilterPage();
            wishlistPage = new WebWishlistPage();
            currencyLanguagePage = new WebCurrencyLanguagePage();
            feedbackPage = new WebFeedbackPage();
            placeDescriptionPage = new WebPlaceDescriptionPage();
        }
        else{
            homePage = new AndroidHomePage();
            loginPage = new AndroidLoginPage();
            staysPage = new AndroidStaysPage();
            experiencesPage = new AndroidExperiencesPage();
            staysFilterPage = new AndroidStaysFilterPage();
            experiencesFilterPage = new AndroidExperiencesFilterPage();
            wishlistPage = new AndroidWishlistPage();
            settingsPage = new AndroidSettingsPage();
            currencyPage = new AndroidCurrencyPage();
            feedbackPage = new AndroidFeedbackPage();
            placeDescriptionPage = new AndroidPlaceDescriptionPage();
        }
    }
}
