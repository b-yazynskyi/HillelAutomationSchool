import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        var driver = getDriver();
        try {
            // Відкрити браузер і перейти за адресою https://guest:welcome2qauto@qauto.forstudy.space/.
            driver.get("https://guest:welcome2qauto@qauto.forstudy.space/");

            System.out.println("Waiting for uploading tittle");
            // Дочекатися тайтла сторінки"Hillel Qauto", використовуючи явне очікування.
            Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.titleContains("Hillel Qauto"));

            System.out.println("Clicking with JS executor");
            // За допомогою JavascriptExecutor клікнути на кнопку "Guest log in".
            clickGuestLogInButton(driver);

            System.out.println("Waiting for Add car button");
            // Дочекатися, поки кнопка "Add car" стане клікабельною, використовуючи явне очікування.
            WebElement addCarButton = driver.findElement(By.cssSelector(".btn-primary"));
            Wait<WebDriver> waitForAddCarButton = new WebDriverWait(driver, Duration.ofSeconds(3));
            waitForAddCarButton.until(ExpectedConditions.elementToBeClickable(addCarButton));

            System.out.println("Clicking on add car button");
            addCarButton.click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        return driver;
    }

    public static void clickGuestLogInButton(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementsByClassName('header-link -guest')[0].click();");
    }
}
