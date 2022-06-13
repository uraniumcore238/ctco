package pages;

import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class VacanciesPage {

    public final static SelenideElement
        vacanciesMainBlock = $(".vacancies-main");

    public final static ElementsCollection
        leftSideMenuItems = $$("#menu-main-1 .menu-item"),
        vacanciesPageTitles = $$(".vacancies-second-contents h1");


    public void findQuantityOfElementsInElement(String pageTitle, String paragraphTitle,
                                                int quantityElementsInParagraph) {
        String xpathElementsInParagraph = "//h1[contains(., '"
                + pageTitle + "')]/..//p[contains(.,'" + paragraphTitle + "')]/following::ul[1]/li";
        $$x(xpathElementsInParagraph).shouldHave(CollectionCondition.size(quantityElementsInParagraph)
                .because("Количество элементов в списке должно быть равно " + quantityElementsInParagraph));
    }

}