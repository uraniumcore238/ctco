package tests;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static config.ConfigHelper.isVideoOn;
import static helper.AttachmentsHelper.*;
import static helper.DriverHelper.*;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

    @BeforeTest
    public static void beforeAll() {
        configureDriver();

    }

    @AfterTest
    public void addAttachments() {
        String sessionId = getSessionId();

        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        if  (isVideoOn()) {
            attachVideo(sessionId);
        }

        closeWebDriver();
    }

    public void hoverOnElementByText(ElementsCollection els, String elementTitle) {
        els.findBy(text(elementTitle)).shouldBe(visible).hover();
    }

    public void verifyVisibility(SelenideElement el) {
        el.shouldBe(visible);
    }

    public void verifyVisibilityByText(ElementsCollection els, String elementTitle) {
        els.findBy(text(elementTitle)).shouldBe(visible);
    }

    public void clickOnElementByText(ElementsCollection els, String text) {
        els.findBy(text(text)).shouldBe(visible).click();
    }

    public void waitForElementByText(ElementsCollection els, String text) {
        SelenideElement el = els.findBy(text(text)).shouldBe(visible);
    }

}
