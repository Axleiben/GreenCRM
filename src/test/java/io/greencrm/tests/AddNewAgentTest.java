package io.greencrm.tests;

import io.greencrm.pages.*;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.io.IOException;
import java.time.Duration;

public class AddNewAgentTest {

    WebDriver driver;
    @BeforeEach
    public void setup()
    {  WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }


   @Test
    public void emailExistsTest()  {


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

        WebElement notification = driver.findElement(By.className("ant-notification-notice-description"));

        String notificationText = notification.getText();

        System.out.println(notificationText);
        Assertion assertion = new Assertion();

        assertion.assertEquals(notificationText, "Podany e-mail istnieje już w systemie");



    }


}
