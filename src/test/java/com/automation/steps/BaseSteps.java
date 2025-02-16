package com.automation.steps;

import com.automation.pages.android.AndroidExperiencesPage;
import com.automation.pages.android.AndroidHomePage;
import com.automation.pages.android.AndroidLoginPage;
import com.automation.pages.android.AndroidStaysPage;
import com.automation.pages.ui.ExperiencesPage;
import com.automation.pages.ui.HomePage;
import com.automation.pages.ui.LoginPage;
import com.automation.pages.ui.StaysPage;
import com.automation.pages.web.WebExperiencesPage;
import com.automation.pages.web.WebHomePage;
import com.automation.pages.web.WebLoginPage;
import com.automation.pages.web.WebStaysPage;
import com.automation.utils.ConfigReader;

public class BaseSteps {

    HomePage homePage;
    LoginPage loginPage;
    StaysPage staysPage;
    ExperiencesPage experiencesPage;

    public BaseSteps(){
        if(ConfigReader.getConfigValue("platform").equals("web")){
            homePage = new WebHomePage();
            loginPage = new WebLoginPage();
            staysPage = new WebStaysPage();
            experiencesPage = new WebExperiencesPage();
        }
        else{
            homePage = new AndroidHomePage();
            loginPage = new AndroidLoginPage();
            staysPage = new AndroidStaysPage();
            experiencesPage = new AndroidExperiencesPage();
        }
    }
}
