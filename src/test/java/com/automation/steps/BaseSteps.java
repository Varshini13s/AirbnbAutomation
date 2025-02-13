package com.automation.steps;

import com.automation.pages.android.AndroidHomePage;
import com.automation.pages.android.AndroidLoginPage;
import com.automation.pages.ui.HomePage;
import com.automation.pages.ui.LoginPage;
import com.automation.pages.web.WebHomePage;
import com.automation.pages.web.WebLoginPage;
import com.automation.utils.ConfigReader;

public class BaseSteps {

    HomePage homePage;
    LoginPage loginPage;

    public BaseSteps(){
        if(ConfigReader.getConfigValue("platform").equals("web")){
            homePage = new WebHomePage();
            loginPage = new WebLoginPage();
        }
        else{
            homePage = new AndroidHomePage();
            loginPage = new AndroidLoginPage();
        }
    }
}
