package helper;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static org.openqa.selenium.logging.LogType.BROWSER;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.ConfigHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverHelper {

    public static void configureDriver() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.baseUrl = ConfigHelper.getWebUrl();
        Configuration.timeout = 10000;
        Configuration.browserSize = "1900x1080";


        if (ConfigHelper.isRemoteWebDriver()) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
            Configuration.remote = ConfigHelper.getWebRemoteDriver();
        }
    }

    public static String getSessionId() {
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString().replace("selenoid","");
    }

    public static String getConsoleLogs() {
        return String.join("\n", Selenide.getWebDriverLogs(BROWSER));
    }
}
