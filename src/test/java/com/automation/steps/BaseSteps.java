package com.automation.steps;

import com.automation.pages.android.*;
import com.automation.pages.ui.*;
import com.automation.pages.web.*;
import com.automation.utils.ConfigReader;

public class BaseSteps {

    HomePage homePage;
    LoginPage loginPage;
    StaysPage staysPage;
    ExperiencesPage experiencesPage;
    StaysFilterPage staysFilterPage;
    ExperiencesFilterPage experiencesFilterPage;

    public BaseSteps(){
        if(ConfigReader.getConfigValue("platform").equals("web")){
            homePage = new WebHomePage();
            loginPage = new WebLoginPage();
            staysPage = new WebStaysPage();
            experiencesPage = new WebExperiencesPage();
            staysFilterPage = new WebStaysFilterPage();
            experiencesFilterPage = new WebExperiencesFilterPage();
        }
        else{
            homePage = new AndroidHomePage();
            loginPage = new AndroidLoginPage();
            staysPage = new AndroidStaysPage();
            experiencesPage = new AndroidExperiencesPage();
            staysFilterPage = new AndroidStaysFilterPage();
            experiencesFilterPage = new AndroidExperiencesFilterPage();
        }
    }
}
