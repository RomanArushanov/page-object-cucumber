package ru.appline.framework.steps;

import io.cucumber.java.ru.Когда;
import ru.appline.framework.managers.PageManager;

public class BusinessTripsSteps {

    PageManager pageManager = PageManager.getPageManager();

    @Когда("Нажимаем на кнопку 'Создать командировку' на странице 'Командировки'")
    public void clickCreateBusinessTripButton() {
        pageManager.getBusinessTrips().clickCreateBusinessTripButton();
    }

}
