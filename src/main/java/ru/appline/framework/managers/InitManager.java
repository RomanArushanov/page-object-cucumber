package ru.appline.framework.managers;

import org.openqa.selenium.Dimension;

public class InitManager {

    private static final DriverManager driverManager = DriverManager.getDriverManager();

    public static void initFramework() {
        driverManager.getDriver().manage().window().setSize(new Dimension(1920,1080));
    }

    public static void quitFramework() {
        driverManager.quitDriver();
    }
}
