package io.greencrm.tests;

import io.greencrm.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.io.IOException;


@Test
public class AddNewAgentTest extends Setting {
    public void emailExistsTest() {


        WebDriver firefoxDriver = new FirefoxDriver();

        firefoxSetting(firefoxDriver);


        LoginPage loginPage = new LoginPage(firefoxDriver);
        SidebarPage sidebarPage = new SidebarPage(firefoxDriver);
        AgentsPage agentsPage = new AgentsPage(firefoxDriver);
        AddNewAgentPage addNewAgentPage = new AddNewAgentPage(firefoxDriver);


        loginPage.logIn();
        sidebarPage.openAgentsPage();
        agentsPage.openNewAgentForm();
        addNewAgentPage.fillNewAgentForm("Jan", "Kowalski", "example@wp.pls", "1000200300");
        addNewAgentPage.markSendEmailChceckbox();
        addNewAgentPage.submittingNewAgentForm();

        WebElement notification = firefoxDriver.findElement(By.className("ant-notification-notice-description"));

        String notificationText = notification.getText();

        System.out.println(notificationText);
        Assertion assertion = new Assertion();

         assertion.assertEquals(notificationText, "Podany e-mail istnieje już w systemie");



    }


}
