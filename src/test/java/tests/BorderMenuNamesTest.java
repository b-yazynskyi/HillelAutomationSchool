package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BorderMenuNamesTest {

    @BeforeSuite
    public void beforeSuite() {
        Configuration.baseUrl = "https://guest:welcome2qauto@qauto.forstudy.space/";
        Configuration.browser = "chrome";
    }

    @Test()
}
