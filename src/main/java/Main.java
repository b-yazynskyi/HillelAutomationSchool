import com.codeborne.selenide.Configuration;
import driver.WbDriver;
import pages.PanelPage;
import pages.QaAutoForStudyPage;
import utils.AppConstants;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public class Main {
    public static void main(String[] args) {

        Configuration.browser = WbDriver.class.getName();
        Configuration.headless = AppConstants.HEADLESS_PROP_MODE;

        try {
            open(AppConstants.BASE_URL);

            QaAutoForStudyPage qaAutoForStudyPage = new QaAutoForStudyPage();
            List<String> textOfBorderMenuButtons = qaAutoForStudyPage.clickGuestLogInPage().getTextOfBorderMenuButtons();

            textOfBorderMenuButtons.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Unfortunately test failed");
        }

    }
}
