package io.greencrm.tests;

import io.greencrm.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;


public class LoginaPageTest {

    WebDriver driver;
    String testUrl = "https://test.greencrm.dev/";
    private LoginPage loginPage;

    @RegisterExtension
    TestStatus status = new TestStatus();
    @AfterEach
    public void afterEach(TestInfo info){
        if(status.isFailed){
            takeScreanshot(info.getDisplayName());
        }
    }

    @BeforeEach
    public void setup() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-search-engine-choice-screen");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }



//    @AfterTest
//    public void quit()
//    {
//        driver.quit();
//    }

    @Test
            public void login_test_positive(){

        loginPage.logIn();

    }
    @Test
    public void wrong_login_should_be_correct_message()  {

        driver.get(testUrl);
        loginPage.getLoginInput().sendKeys("fdsfd");
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

    public void takeScreanshot(String testName)  {

        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String folderLocation = "./screenshots/";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
        String formattedNow = LocalDateTime.now().format(formatter);

        try {
        Files.createDirectories(Paths.get(folderLocation));
        Path destinationPath = Paths.get(folderLocation + testName + formattedNow + ".png");
        Files.copy(screenshot.toPath(),destinationPath);
        System.out.println("Screenshot saved at " + destinationPath );

        } catch (IOException e) {
            throw new RuntimeException(e);
       }


    }


}
