package ru.appline.framework.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {

    @FindBy(xpath = "//h1[text()='Панель быстрого запуска']")
    private WebElement mainPageTitle;

    @FindBy(xpath = "//ul[contains(@class,'main-menu')]/li/a/span[@class='title']")
    private List<WebElement> mainMenu;

    @FindBy(xpath = "//span[text()='Командировки']")
    private WebElement businessTripsButton;

    private final String costsListDropDownMenu = "[text()='%s']/ancestor::li//ul[@class='dropdown-menu menu_level_1']";

    public MainPage checkMainPageTitle() {
        Assertions.assertTrue(mainPageTitle.isDisplayed(), "На странице отсутствует заголовок 'Панель быстрого запуска'");
        return this;
    }

    public MainPage clickButtonOfMainMenu(String buttonName) {
        for (WebElement element: mainMenu) {
            if (element.getText().trim().equalsIgnoreCase(buttonName)) {
                waitUtilElementToBeClickable(element).click();
                return this;
            }
        }
        Assertions.fail(String.format("Кнопка '%s' не найдена на странице", buttonName));
        checkDropDownListExists(buttonName);
        return this;
    }

    @Step("Проверяем, что появился выпадающий список после нажатия кнопки '{buttonName}'")
    public MainPage checkDropDownListExists(String buttonName) {
        for (WebElement element: mainMenu) {
            if (element.getText().trim().equalsIgnoreCase(buttonName)) {
                waitUtilElementToBeVisible(element.findElement(By.xpath(costsListDropDownMenu)));
            }
        }
        Assertions.fail(String.format("Выпадающий список осле нажатия кнопки '%s' не появился", buttonName));
        return this;
    }

    public BusinessTrips selectBusinessTripModuleInCostsBlock() {
        waitUtilElementToBeClickable(businessTripsButton).click();
        checkLoadingWindow();
        return pageManager.getBusinessTrips();
    }
}
