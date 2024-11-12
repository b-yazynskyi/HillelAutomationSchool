package pages.basePage;

import static com.codeborne.selenide.Selenide.open;

public abstract class BasePage {

    public static void navigateToPage(String url) {
        open(url);
    }
}
