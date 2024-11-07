package pages;

import static com.codeborne.selenide.Selenide.open;

public class BasePage {

    public BasePage() {}

    public static void navigateToPage(String url) {
        open(url);
    }
}
