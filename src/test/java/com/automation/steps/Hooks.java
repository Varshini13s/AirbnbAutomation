package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.net.MalformedURLException;

public class Hooks {
    @Before
    public void setUp() {
        ConfigReader.intiConfig();
        DriverManager.createDriver();
    }


//    @After
//    public void cleanUp() {
//        DriverManager.getDriver().quit();
//    }
//
//    @AfterStep
//    public static void cleanUpAll(Scenario scenario) {
//        byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
//        scenario.attach(screenshot, "image/png", "Step screenshot");
//    }
}
