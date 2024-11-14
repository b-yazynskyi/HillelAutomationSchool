package pages.basePage;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public abstract class BasePage {

    @Step("Open the website")
    public static void navigateToPage(String url) {
        open(url);
    }
}
