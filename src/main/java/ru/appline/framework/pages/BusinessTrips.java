package ru.appline.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BusinessTrips extends BasePage {

    @FindBy(xpath = "//a[@title='Создать командировку']")
    private WebElement createBusinessTripButton;

    public CreateBusinessTripPage clickCreateBusinessTripButton() {
        waitUtilElementToBeClickable(createBusinessTripButton).click();
        checkLoadingWindow();
        return pageManager.getCreateBusinessTripPage();
    }
}
