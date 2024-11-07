package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.$$x;

public class PanelPage {
    private final ElementsCollection BORDER_MENU_BUTTONS =
            $$x("//*[contains(@class, \"btn-sidebar sidebar_btn\")]");

    public List<String> getTextOfBorderMenuButtons() {
        return BORDER_MENU_BUTTONS.stream().filter(Objects::nonNull).map(SelenideElement::getText).toList();
    }
}
