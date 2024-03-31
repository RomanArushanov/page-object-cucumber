package ru.appline.framework.steps;

import io.cucumber.java.ru.Когда;
import ru.appline.framework.managers.PageManager;

public class MainPageSteps {

    PageManager pageManager = PageManager.getPageManager();

    @Когда("Проверяем наличие заголовка 'Панель быстрого запуска'")
    public void checkMainPageTitle() {
        pageManager.getMainPage().checkMainPageTitle();
    }

    @Когда("Нажимаем на кнопку {string}")
    public void clickButtonOfMainMenu(String buttonName) {
        pageManager.getMainPage().clickButtonOfMainMenu(buttonName);
    }

    @Когда("Выбираем из выпадающего списка кнопку 'Командировки'")
    public void selectBusinessTripModuleInCostsBlock() {
        pageManager.getMainPage().selectBusinessTripModuleInCostsBlock();
    }


}
