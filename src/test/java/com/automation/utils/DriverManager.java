package com.automation.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class DriverManager {

    static WebDriver driver;

    public static void createDriver() {
        if (ConfigReader.getConfigValue("platform").equals("web")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if (ConfigReader.getConfigValue("platform").equals("mobile")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", ConfigReader.getConfigValue("platform.name"));
            capabilities.setCapability("automationName", ConfigReader.getConfigValue("automation.name"));
            capabilities.setCapability("appium:app", System.getProperty("user.dir") + ConfigReader.getConfigValue("app.path"));
            capabilities.setCapability("deviceName", ConfigReader.getConfigValue("device.name"));
            capabilities.setCapability("appPackage", ConfigReader.getConfigValue("app.package"));
            capabilities.setCapability("appActivity", ConfigReader.getConfigValue("app.activity"));

            driver = new AndroidDriver(capabilities);
        } else {
            throw new RuntimeException("'platform' parameter value can be web or mobile");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
