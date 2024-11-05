package pages;

import org.openqa.selenium.WebDriver;

public interface Page {
    String BASE_URL = "https://guest:welcome2qauto@qauto.forstudy.space/";

    WebDriver getDriver();


    String GARAGE_BUTTON = "//a[@routerLink='garage']";
    String FUEL_EXPENSES_BUTTON = "//a[@routerLink='expenses']";
    String INSTRUCTIONS_BUTTON = "//a[@routerLink='instructions']";
    String LOG_OUT_BUTTON = "//a[@class='btn btn-link text-danger btn-sidebar sidebar_btn']";
}