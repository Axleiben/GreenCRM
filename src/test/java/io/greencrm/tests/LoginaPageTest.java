package io.greencrm.tests;

import io.greencrm.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class LoginaPageTest  {

    WebDriver driver;
    String testUrl = "https://test.greencrm.dev/";
    @BeforeEach
    public void setup() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-search-engine-choice-screen");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
            public void login_test_positive(){

        LoginPage loginPage = new LoginPage(driver);
        driver.get(testUrl);
        loginPage.logIn();

    }
    @Test
    public void wrong_login(){
        LoginPage loginPage = new LoginPage(driver);
        driver.get(testUrl);
        loginPage.setLogin("adddad");
        loginPage.setPassword("Avocado1357!#");
        loginPage.loginButton();
       String text = driver.findElement(By.className("ant-notification-close-x")).getText();
        System.out.println(text);
    }




}
