package io.greencrm.tests;

import io.greencrm.pages.BasePage;
import io.greencrm.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class LoginaPageTest   {

    WebDriver driver;
    String testUrl = "https://test.greencrm.dev/";


    @BeforeEach
    public void setup() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-search-engine-choice-screen");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
            public void login_test_positive(){

        LoginPage loginPage = new LoginPage(driver);

        loginPage.logIn();

    }
    @Test
    public void wrong_login_should_be_correct_message(){
        LoginPage loginPage = new LoginPage(driver);
        driver.get(testUrl);
        loginPage.setLogin("adddad");
        loginPage.setPassword("Avocado1357!#");
        loginPage.loginButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-notification-notice-description")));

        String text = driver.findElement(By.className("ant-notification-notice-description")).getText();
        System.out.println(text);
        Assertion assertion = new Assertion();
        assertion.assertEquals(text,"Błędny login lub hasło","wrong bad login message");


    }

    @Test
    public void wrong_password_should_be_correct_message(){
        LoginPage loginPage = new LoginPage(driver);
        driver.get(testUrl);
        loginPage.setLogin("Melania@wp.pl");
        loginPage.setPassword("Aaaaaaaa");
        loginPage.loginButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-notification-notice-description")));

        String text = driver.findElement(By.className("ant-notification-notice-description")).getText();
        System.out.println(text);
        Assertion assertion = new Assertion();
        assertion.assertEquals(text,"Błędny login lub hasło","wrong bad login message");


    }


}
