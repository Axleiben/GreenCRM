package io.greencrm.tests;

import io.greencrm.pages.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class AddNewAgentTest {

    private WebDriver driver;
    private SoftAssert softAssert;
    private LoginPage loginPage;
    private SidebarPage sidebarPage;
    private AgentsPage agentsPage ;
    private AddNewAgentPage addNewAgentPage;


    @BeforeEach
    public void setup()
    {  ChromeOptions chromeOptions = new ChromeOptions();
         chromeOptions.addArguments("--disable-search-engine-choice-screen");
         chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
         driver = new ChromeDriver(chromeOptions);
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         loginPage = new LoginPage(driver);
         sidebarPage = new SidebarPage(driver);
         agentsPage = new AgentsPage(driver);
         addNewAgentPage = new AddNewAgentPage(driver);
         softAssert = new SoftAssert();


    }

    @AfterTest
    public void quit()
    {
        driver.quit();
    }
  @Test
 public void email_exists_should_not_create_new_agent()  {

      loginPage.logIn();
        sidebarPage.goToAgentsPage();
        agentsPage.goToNewAgentForm();
        addNewAgentPage.fillNewAgentForm("Jan",
                                        "Kowalski",
                                        "example@wp.pls",
                                        "1000200300");
        addNewAgentPage.markSendEmailChceckbox();
        addNewAgentPage.submittingNewAgentForm();

        WebElement notification = driver.findElement(By.className("ant-notification-notice-content"));

        String notificationText = notification.getText();
        System.out.println(notificationText);
        Assertion assertion = new Assertion();
        assertion.assertEquals(notificationText, "Błąd\n" +
                "Podany e-mail istnieje już w systemie");



    }


@Test
 public void name_input_validation_should_show_proper_notification(){

    loginPage.logIn();
    sidebarPage.goToAgentsPage();
    agentsPage.goToNewAgentForm();

    addNewAgentPage.getFirstNameInput().sendKeys("a");
    addNewAgentPage.submittingNewAgentForm();
    String moreThanTwoSignsError = driver.findElement(By.className("ant-form-item-explain-error")).getText();
    softAssert.assertEquals(moreThanTwoSignsError,"Pole powinno składać się z co najmniej 2 znaków","Komunikat bledu jest nieprawidlowy");
    addNewAgentPage.getFirstNameInput().clear();

    addNewAgentPage.getFirstNameInput().sendKeys("23");
    String onlyLettersError = driver.findElement(By.className("ant-form-item-explain-error")).getText();
    softAssert.assertEquals(onlyLettersError,"Pole może składać się jedynie z liter","Komunikat bledu jest nieprawidlowy");
    addNewAgentPage.getFirstNameInput().sendKeys(Keys.CONTROL + "a" +Keys.DELETE);

    addNewAgentPage.fillFirstNameInput("   ");
    String noWhiteSignsError = driver.findElement(By.className("ant-form-item-explain-error")).getText();
    softAssert.assertEquals(noWhiteSignsError,"Pole nie może składać się z pustych znaków","Komunikat bledu jest nieprawidlowy");

    softAssert.assertAll();

}


@Test
    public void testy(){
    LoginPage loginPage = new LoginPage(driver);
    SidebarPage sidebarPage = new SidebarPage(driver);
    AgentsPage agentsPage = new AgentsPage(driver);
    AddNewAgentPage addNewAgentPage = new AddNewAgentPage(driver);


    loginPage.logIn();
    sidebarPage.goToAgentsPage();

}



}
