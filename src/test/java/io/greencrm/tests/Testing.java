package io.greencrm.tests;

import io.greencrm.pages.*;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.Test;

import java.util.Set;


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
    sidebarPage.openAgentsPage();
    agentsPage.openNewAgentForm();
    addNewAgentPage.fillNewAgentForm("Jan","Kowalski", "example@wp.pls","1000200300");
    addNewAgentPage.markSendEmailChceckbox();
    addNewAgentPage.submittingNewAgentForm();




    }



}