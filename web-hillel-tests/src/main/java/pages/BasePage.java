package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public abstract class BasePage {

    protected void selectByElementTypeInDropDown(ElementsCollection dropdownElements, String elementName) {
        dropdownElements.shouldBe(CollectionCondition.sizeGreaterThan(0));
        for (SelenideElement element : dropdownElements) {
            if (element.getText().equals(elementName)
                    && !Objects.requireNonNull(element.getAttribute("class")).contains("disabled")) {
                log.info("Clicking on element: {}", element.getText());
                element.click();
                return;
            }
        }
        log.warn("No matching and enabled element found for {}", elementName);
    }
}
