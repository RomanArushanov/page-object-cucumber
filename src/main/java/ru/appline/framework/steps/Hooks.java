package ru.appline.framework.steps;

import io.cucumber.java.*;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.appline.framework.managers.DriverManager;
import ru.appline.framework.managers.InitManager;
import ru.appline.framework.managers.PropertiesManager;

import java.io.ByteArrayInputStream;

import static ru.appline.framework.utils.constants.PropertiesConstants.BASE_URL;

public class Hooks {

    private final DriverManager driverManager = DriverManager.getDriverManager();

    @BeforeAll
    public static void beforeAll() {
        InitManager.initFramework();
    }

    @Before
    public void beforeEach() {
        driverManager.getDriver().get(PropertiesManager.getPropertyManager().getProperty(BASE_URL));
    }

    @AfterStep
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            Allure.addAttachment(scenario.getId(), new ByteArrayInputStream(((TakesScreenshot) driverManager.getDriver())
                    .getScreenshotAs(OutputType.BYTES)));
        }
    }

    @AfterAll
    public static void afterAll() {
        InitManager.quitFramework();
    }
}
