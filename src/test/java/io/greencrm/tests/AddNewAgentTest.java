package io.greencrm.tests;

import io.greencrm.pages.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.asserts.Assertion;

import java.util.concurrent.TimeUnit;

public class AddNewAgentTest {

    WebDriver driver;
    @BeforeEach
    public void setup()
    {  ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-search-engine-choice-screen");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


  @Test
 public void email_exists_should_not_create_new_agent()  {


        LoginPage loginPage = new LoginPage(driver);
        SidebarPage sidebarPage = new SidebarPage(driver);
        AgentsPage agentsPage = new AgentsPage(driver);
        AddNewAgentPage addNewAgentPage = new AddNewAgentPage(driver);


        loginPage.logIn();
        sidebarPage.openAgentsPage();
        agentsPage.openNewAgentForm();
        addNewAgentPage.fillNewAgentForm("Jan", "Kowalski", "example@wp.pls", "1000200300");
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

}


@Test
    public void testy(){
    LoginPage loginPage = new LoginPage(driver);
    SidebarPage sidebarPage = new SidebarPage(driver);
    AgentsPage agentsPage = new AgentsPage(driver);
    AddNewAgentPage addNewAgentPage = new AddNewAgentPage(driver);


    loginPage.logIn();
    sidebarPage.openAgentsPage();

}



}
