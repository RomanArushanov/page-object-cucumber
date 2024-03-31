package ru.appline.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.appline.framework.utils.enums.Enums;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateBusinessTripPage extends BasePage {

    @FindBy(xpath = "//div[@class='row']//h1[@class='user-name']")
    private WebElement createBusinessTripTitle;

    @FindBy(xpath = "//select[contains(@id,'crm_business_trip_businessUnit')]")
    private WebElement divisionBlock;

    @FindBy(xpath = "//option[text()='Отдел внутренней разработки']")
    private WebElement internalDevelopmentDepartmentButton;

    @FindBy(xpath = "//a[text()='Открыть список']")
    private WebElement openListButton;

    @FindBy(xpath = "//div[contains(@class,'select2-container')]")
    private WebElement organisationBlock;

    @FindBy(xpath = "//li[contains(@class,'select2-results')]/..")
    private WebElement organisationDropDownMenu;

    @FindBy(xpath = "//li[contains(@class,'select2-results')]")
    private List<WebElement> organisationDropDownList;

    @FindBy(xpath = "//span[contains(text(),'(Хром) Призрачная Организация Охотников')]")
    private WebElement organisation;

    @FindBy(xpath = "//input[@data-ftid='crm_business_trip_departureCity']")
    private WebElement departureCityInputField;

    @FindBy(xpath = "//input[@data-ftid='crm_business_trip_arrivalCity']")
    private WebElement arrivalCityInputField;

    @FindBy(xpath = "//input[contains(@id,'departureDatePlan') and contains(@class,'datepicker-input')]")
    private WebElement plannedDepartureDateInputField;

    @FindBy(xpath = "//input[contains(@id,'returnDatePlan') and contains(@class,'datepicker-input')]")
    private WebElement plannedReturnDateInputField;

    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    private WebElement clickAndSaveButton;

    @FindBy(xpath = "//label[text()='Командированные сотрудники']/../..//span[text()='Список командируемых сотрудников не может быть пустым']")
    private WebElement errorMessage;

    private final String tasksCheckBox = "//label[text()='%s']//preceding-sibling::input";

    public CreateBusinessTripPage checkCreateBusinessTripTitle() {
        assertTrue(waitUtilElementToBeVisible(createBusinessTripTitle).isDisplayed(),
                "На странице отсутствует заголовок 'Создать командировку'");
        return this;
    }

    public CreateBusinessTripPage chooseInternalDevelopmentDepartment() {
        divisionBlock.click();
        internalDevelopmentDepartmentButton.click();
        divisionBlock.click();
        return this;
    }

    public CreateBusinessTripPage clickOpenListButton() {
        openListButton.click();
        return this;
    }

    public CreateBusinessTripPage chooseOrganisation(String organisationName) {
        organisationBlock.click();
        waitUtilElementToBeVisible(organisationDropDownMenu);
        for (WebElement organisation: organisationDropDownList) {
            if (organisation.getText().contains(organisationName)) {
                waitUtilElementToBeClickable(organisation).click();
                return this;
            }
        }
        Assertions.fail(String.format("Организации '%s' нет в списке",  organisationName));
        return this;
    }

    public CreateBusinessTripPage selectTasksCheckBox(String checkBoxValue) {
        driverManager.getDriver().findElement(By.xpath(String.format(tasksCheckBox, checkBoxValue))).click();
        return this;
    }

    public CreateBusinessTripPage fillTravelFields(String enumsValue, String value) {
        if (enumsValue.equals(Enums.DEPARTURE_CITY.getValue())) {
            fillInputField(departureCityInputField, value);
        } else if (enumsValue.equals(Enums.ARRIVAL_CITY.getValue())) {
            fillInputField(arrivalCityInputField, value);
        } else if (enumsValue.equals(Enums.DEPARTURE_DATE.getValue())) {
            fillInputField(plannedDepartureDateInputField, value);
        } else if (enumsValue.equals(Enums.RETURN_DATE.getValue())) {
            fillInputField(plannedReturnDateInputField, value);
        } else {
            Assertions.fail(String.format("Для поля '%s' отсутствует необходимый функционал", value));
        }
        return this;
    }

    public CreateBusinessTripPage checkAllFieldsFilled(String value) {
        switch (value) {
            case "Отдел внутренней разработки":
                assertTrue(scrollToElementJs(internalDevelopmentDepartmentButton).getText().contains(value),
                        String.format("Блок 'Подразделение' не содержит в себе текст '%s'", value));
                break;
            case "(Хром) Призрачная Организация Охотников":
                assertTrue(scrollToElementJs(organisation).getText().contains(value),
                        String.format("Блок 'Подразделение' не содержит в себе текст '%s'", value));
                break;
            case "Энгельс":
                assertTrue(scrollToElementJs(departureCityInputField).getAttribute("value").contains(value),
                        String.format("Поле 'Город выбытия' не содержит текст '%s'", value));
                break;
            case "Москва":
                assertTrue(scrollToElementJs(arrivalCityInputField).getAttribute("value").contains(value),
                        String.format("Поле 'Город прибытия' не содержит текст '%s'", value));
                break;
            case "10.11.2023":
                assertFalse(scrollToElementJs(plannedDepartureDateInputField).getText().contains("datepicker-input  hasDatepicker error"),
                        "Поле 'Планируемая дата выезда' не содержит текст");
                break;
            case "10.12.2023":
                assertFalse(scrollToElementJs(plannedReturnDateInputField).getText().contains("datepicker-input  hasDatepicker error"),
                        "Поле 'Планируемая дата возвращения' не содержит текст");
                break;
            case "Заказ билетов":
                assertTrue(scrollToElementJs(driverManager.getDriver().findElement(By.xpath(String.format(tasksCheckBox, value)))).isSelected(),
                        String.format("Чекбокс '%s' не поставлен", value));
                break;
            default:
                Assertions.fail(String.format("Для поля '%s' отсутствует необходимый функционал", value));
        }
        return this;
    }

    public CreateBusinessTripPage clickSaveAndCloseButton() {
        clickElementByJS(clickAndSaveButton);
        checkLoadingWindow();
        return this;
    }

    public CreateBusinessTripPage checkErrorMessage(String value) {
        waitUtilElementToBeVisible(errorMessage);
        assertTrue(errorMessage.getText().contains(value),
                String.format("На странице не появилось сообщение: '%s'", value));
        return this;
    }
}
