package pages;


import com.browserup.bup.proxy.CaptureType;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.net.NetworkUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.AppConfigUtils;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;
import java.util.random.RandomGenerator;

import static com.codeborne.selenide.Selenide.*;

public abstract class BaseTest {

    @BeforeSuite
    public void setUpSelenideLogger() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(false)
                );
    }

    @BeforeMethod
    public void initBrowser() {
        configBrowser();
        configProxy();
        clearBrowser();
    }

    private void configBrowser() {
        if (AppConfigUtils.CONFIG.isSelenoid()) {
            Configuration.remote = AppConfigUtils.CONFIG.selenoidRemote();
        }

        if (AppConfigUtils.CONFIG.isHeadless()) {
            Configuration.headless = true;
        }

        Configuration.proxyEnabled = true;
        Configuration.proxyHost = new NetworkUtils().getNonLoopbackAddressOfThisMachine();
        Configuration.fileDownload = FileDownloadMode.PROXY;

        Configuration.browser = AppConfigUtils.CONFIG.browserName();
        Configuration.browserSize = "1920x1080";
        Configuration.screenshots = true;
        Configuration.savePageSource = true;
        Configuration.reportsFolder = "test-result/reports";

        configCapabilities();

        open("https://guest:welcome2qauto@qauto.forstudy.space");
    }

    private void configCapabilities() {
        var capabilities = new DesiredCapabilities();

        capabilities.setCapability("browserName", AppConfigUtils.CONFIG.browserName());
        capabilities.setCapability("acceptInsecureCerts", true);

        var selenoidOptions = new HashMap<String, Object>();
        selenoidOptions.put("enableVNC", AppConfigUtils.CONFIG.isVnc());
        selenoidOptions.put("enableVideo", AppConfigUtils.CONFIG.isEnableVideo());
        selenoidOptions.put("videoName", "testVideo"
                + RandomStringUtils.random(3, 0, 0, true, true, null) + ".mp4");
        selenoidOptions.put("timeZone", "Europe/Kyiv");

        capabilities.setCapability("selenoid:options", selenoidOptions);
        Configuration.browserCapabilities = capabilities;
    }

    private void configProxy() {
        var proxy = Objects.requireNonNull(WebDriverRunner.getSelenideProxy()).getProxy();
        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
        proxy.addRequestFilter(((httpRequest, httpMessageContents, httpMessageInfo) -> {
            httpRequest.headers().remove("Accept-language");
            return null;
        }));
    }

    private void clearBrowser() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
    }
}
