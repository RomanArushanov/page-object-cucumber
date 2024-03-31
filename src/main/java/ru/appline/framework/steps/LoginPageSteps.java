package ru.appline.framework.steps;

import io.cucumber.java.ru.Когда;
import ru.appline.framework.managers.PageManager;

public class LoginPageSteps {

    PageManager pageManager = PageManager.getPageManager();

    @Когда("Выполняем авторизацию в системе")
    public void authorisation() {
        pageManager.getLoginPage().authorisation();
    }
}
