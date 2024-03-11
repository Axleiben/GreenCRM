package io.greencrm.tests;

import io.greencrm.pages.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.*;


import java.time.Duration;
import java.util.Set;

import static java.lang.Thread.sleep;


public class Testing extends Setting  {
@Test
    public void testPage()  {


    WebDriver firefoxDriver = new FirefoxDriver();

    firefoxSetting(firefoxDriver);


    LoginPage loginPage = new LoginPage(firefoxDriver);
    SidebarPage sidebarPage = new SidebarPage(firefoxDriver);
    AgentsPage agentsPage = new AgentsPage(firefoxDriver);
    AddNewAgentPage addNewAgentPage = new AddNewAgentPage(firefoxDriver);


    loginPage.logIn();
    WebElement a = firefoxDriver.findElement(By.className("ant-notification-close-x"));
    a.click();
    sidebarPage.openAgentsPage();
    agentsPage.openNewAgentForm();
    addNewAgentPage.fillNewAgentForm("Jan","Kowalski", "example@wp.pls","1000200300");
    addNewAgentPage.markSendEmailChceckbox();
    addNewAgentPage.submittingNewAgentForm();

    WebDriverWait wait = new WebDriverWait(firefoxDriver, Duration.ofSeconds(2));
    WebElement notification = firefoxDriver.findElement(By.className("ant-notification-notice-description"));

    String notificationText = notification.getText();

    System.out.println(notificationText);
    Assertion assertion = new Assertion();
   assertion.assertEquals(notificationText,"Podany e-mail istnieje już w systemie");




    }



}