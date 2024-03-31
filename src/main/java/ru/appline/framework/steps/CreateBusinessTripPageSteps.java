package ru.appline.framework.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Когда;
import ru.appline.framework.managers.PageManager;

public class CreateBusinessTripPageSteps {

    PageManager pageManager = PageManager.getPageManager();

    @Когда("Проверяем наличие заголовка 'Создать командировку'")
    public void checkCreateBusinessTripTitle() {
        pageManager.getCreateBusinessTripPage().checkCreateBusinessTripTitle();
    }

    @Когда("Выбираем подразделение 'Отдел внутренней разработки'")
    public void chooseInternalDevelopmentDepartment() {
        pageManager.getCreateBusinessTripPage().chooseInternalDevelopmentDepartment();
    }

    @Когда("Нажимаем на кнопку 'Открыть список' в меню выбора организации")
    public void clickOpenListButton() {
        pageManager.getCreateBusinessTripPage().clickOpenListButton();
    }

    @Когда("Выбираем организацию {string} из списка")
    public void chooseOrganisation(String organisationName) {
        pageManager.getCreateBusinessTripPage().chooseOrganisation(organisationName);
    }

    @Когда("В блоке 'Задачи' отмечаем чекбокс {string}")
    public void selectTasksCheckBox(String checkBoxValue) {
        pageManager.getCreateBusinessTripPage().selectTasksCheckBox(checkBoxValue);
    }

    @Когда("Заполняем поля формы:")
    public void fillTravelFields(DataTable mapFieldsAndValue) {
        mapFieldsAndValue.asMap(String.class, String.class).forEach((key, value) ->
                pageManager.getCreateBusinessTripPage().fillTravelFields(key, value));
    }

    @Когда("Проверяем, что поля заполнены:")
    public void checkAllFieldsFilled(DataTable dataTableValue) {
        dataTableValue.asList(String.class).forEach((value) ->
                pageManager.getCreateBusinessTripPage().checkAllFieldsFilled(value));
    }

    @Когда("Нажимаем кнопку 'Сохранить и выйти'")
    public void clickSaveAndCloseButton() {
        pageManager.getCreateBusinessTripPage().clickSaveAndCloseButton();
    }

    @Когда("Проверяем, что на странице содержится сообщение об ошибке {string}")
    public void checkErrorMessage(String value) {
        pageManager.getCreateBusinessTripPage().checkErrorMessage(value);
    }
}
