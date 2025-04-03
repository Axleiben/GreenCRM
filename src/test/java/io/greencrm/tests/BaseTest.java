package io.greencrm.tests;

import io.greencrm.pages.LoginPage;
import io.greencrm.pages.SidebarPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;




public class BaseTest {
    protected  WebDriver driver;
    protected   WebDriverWait wait;
    protected  Assertion assertion;
    protected SoftAssert softAssert;
    protected Actions action;
    protected LoginPage loginPage;
    protected SidebarPage sidebarPage;
    protected  String testUrl = "https://test.greencrm.dev/";

    @BeforeEach
    public void  setup() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-search-engine-choice-screen");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        assertion = new Assertion();
        softAssert = new SoftAssert();
        action = new Actions(driver);
        loginPage = new LoginPage(driver);
        sidebarPage = new SidebarPage(driver);
    }

    @RegisterExtension
    TestStatus status = new TestStatus();

    @AfterEach
    public void afterEach(TestInfo info){
        if(status.isFailed){
            takeScreanshot(info.getDisplayName());
        }
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

//    @AfterEach
//    public void quit()
//    {
//        driver.quit();
//    }


}
