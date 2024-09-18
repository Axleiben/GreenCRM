package io.greencrm.tests;

import io.greencrm.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class AddNewAgentTest {
    WebDriver firefoxdriver = new FirefoxDriver();

    LoginPage loginPage = new LoginPage(firefoxdriver);
    SidebarPage sidebarPage = new SidebarPage(firefoxdriver);
    AgentsPage agentsPage = new AgentsPage(firefoxdriver);

    AddNewAgentPage addNewAgentPage = new AddNewAgentPage(firefoxdriver);


@Test
    public void AddNewAgentTest(){

        setting.firefoxSetting();
        loginPage.logIn();
        sidebarPage.openAgentsPage();
        agentsPage.openNewAgentForm();
        addNewAgentPage.fillAgentForm("Marek","Kondrat","exemple112@wp.pl","100200300");







    }
}
