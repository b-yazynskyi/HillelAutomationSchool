package pages;

import org.openqa.selenium.WebDriver;

public interface Page {
    String BASE_URL = "https://guest:welcome2qauto@qauto.forstudy.space/";

    WebDriver getDriver();
}
