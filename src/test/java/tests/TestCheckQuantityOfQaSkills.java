package tests;

import static io.qameta.allure.Allure.step;
import static pages.MainPage.*;
import static pages.SecondLayerMenu.*;
import static pages.VacanciesPage.*;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.VacanciesPage;

public class TestCheckQuantityOfQaSkills extends TestBase {

    MainPage mainPage = new MainPage();
    VacanciesPage vacanciesPage = new VacanciesPage();

    @Epic(value = "Example Epic")
    @Feature(value = "Example Feature")
    @Story(value = "Example Story")
    @Owner(value = "Example owner")
    @Test
    void checkSkillsQuantity() {

        step("Open main page of the site ctco.lv", () -> mainPage.openMainPage());
        step("Hover on main menu element Careers", () -> hoverOnElementByText(
                mainMenuItems, "Careers"));
        step("Wait for visibility of Vacancies menu element", () -> verifyVisibilityByText(secondLayerMenuItems,
                "Vacancies"));
        step("Click on Vacancies", () -> clickOnElementByText(secondLayerMenuItems, "Vacancies"));
        step("Wait for visibility of Vacancies page", () -> verifyVisibility(vacanciesMainBlock));
        step("Click on TEST AUTOMATION ENGINEER in side menu", () -> clickOnElementByText(leftSideMenuItems,
                "TEST AUTOMATION ENGINEER"));
        step("Wait for Test automation engineer page is opened", () -> waitForElementByText(vacanciesPageTitles,
                "TEST AUTOMATION ENGINEER"));
        step("Assert that quantity of skills equals 5", () -> vacanciesPage.findQuantityOfElementsInElement(
                "TEST AUTOMATION ENGINEER",
                        "Professional skills and qualification",5));

    }

}
