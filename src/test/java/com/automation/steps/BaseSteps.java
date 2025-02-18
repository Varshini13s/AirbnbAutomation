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
    FilterPage filterPage;

    public BaseSteps(){
        if(ConfigReader.getConfigValue("platform").equals("web")){
            homePage = new WebHomePage();
            loginPage = new WebLoginPage();
            staysPage = new WebStaysPage();
            experiencesPage = new WebExperiencesPage();
            filterPage = new WebFilterPage();
        }
        else{
            homePage = new AndroidHomePage();
            loginPage = new AndroidLoginPage();
            staysPage = new AndroidStaysPage();
            experiencesPage = new AndroidExperiencesPage();
            filterPage = new AndroidFilterPage();
        }
    }
}
