package ru.appline.framework.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static ru.appline.framework.utils.constants.PropertiesConstants.PATH_CHROME_DRIVER_WINDOWS;

public class DriverManager {

    private WebDriver driver;

    private static DriverManager INSTANCE = null;

    private final PropertiesManager properties = PropertiesManager.getPropertyManager();

    private DriverManager() {
    }

    public static DriverManager getDriverManager() {
        if (INSTANCE == null) {
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private void initDriver() {
        System.setProperty("webdriver.chrome.driver", properties.getProperty(PATH_CHROME_DRIVER_WINDOWS));
        driver = new ChromeDriver();
    }
}