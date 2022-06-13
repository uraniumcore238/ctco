package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class MainPage {

    public final static SelenideElement
        mainMenu = $("#menu-main");

    public final static ElementsCollection
        mainMenuItems = mainMenu.$$(".menu-item");


    @Step("Open main page")
    public void openMainPage() {
        open("");
        mainMenu.shouldBe(visible);
    }
}
