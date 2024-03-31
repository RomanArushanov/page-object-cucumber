package ru.appline.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.appline.framework.managers.PropertiesManager;

import static ru.appline.framework.utils.constants.PropertiesConstants.USER_LOGIN;
import static ru.appline.framework.utils.constants.PropertiesConstants.USER_PASSWORD;

public class LoginPage extends BasePage {

    private final PropertiesManager properties = PropertiesManager.getPropertyManager();

    @FindBy(xpath = "//form[@id='login-form']")
    private WebElement loginForm;

    @FindBy(xpath = "//input[@name='_username']")
    private WebElement loginInputField;

    @FindBy(name = "_password")
    private WebElement passwordInputField;

    @FindBy(xpath = "//button[normalize-space('Войти')]")
    private WebElement enterButton;

    public MainPage authorisation() {
        waitUtilElementToBeVisible(loginForm);
        loginInputField.sendKeys(properties.getProperty(USER_LOGIN));
        passwordInputField.sendKeys(properties.getProperty(USER_PASSWORD));
        enterButton.click();
        return pageManager.getMainPage();
    }
}
