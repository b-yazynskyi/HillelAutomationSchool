import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.PanelPage;

import java.time.Duration;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        MainPage mainPage = new MainPage(driver);
        PanelPage panelPage = mainPage.openPage().clickGuestLogInButton();

        List<String> borderMenuButtonsText = panelPage.getBorderMenuButtonsText();

        borderMenuButtonsText.forEach(System.out::println);

        driver.quit();
    }
}
