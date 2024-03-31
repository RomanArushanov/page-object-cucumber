package ru.appline.framework.managers;

import ru.appline.framework.pages.*;

public class PageManager {

    private static PageManager pageManager;

    /**
     * Страница авторизации
     */
    private LoginPage loginPage;

    /**
     * Основная страница
     */
    private MainPage mainPage;

    /**
     * Страница командировок
     */
    private BusinessTrips businessTrips;

    /**
     * Страница создания командировки
     */
    private CreateBusinessTripPage createBusinessTripPage;

    private PageManager() {
    }

    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public MainPage getMainPage() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }

    public BusinessTrips getBusinessTrips() {
        if (businessTrips == null) {
            businessTrips = new BusinessTrips();
        }
        return businessTrips;
    }

    public CreateBusinessTripPage getCreateBusinessTripPage() {
        if (createBusinessTripPage == null) {
            createBusinessTripPage = new CreateBusinessTripPage();
        }
        return createBusinessTripPage;
    }
}
