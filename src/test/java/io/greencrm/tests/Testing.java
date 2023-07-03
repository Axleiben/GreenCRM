package io.greencrm.tests;

import io.greencrm.pages.LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Testing {
@Test
    public void testPage(){

                System.setProperty("webdriver.chrome.driver","C:\\Users\\BRITENET\\OneDrive\\Pulpit\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://test.greencrm.dev");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn();

    }


}
