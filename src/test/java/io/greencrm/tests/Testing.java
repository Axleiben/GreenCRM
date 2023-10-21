package io.greencrm.tests;

import io.greencrm.pages.*;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;



public class Testing {
    @Test
    public void testPage() throws InterruptedException {

        Setting setting = new Setting();
        setting.useSettings();


        LoginPage loginPage = new LoginPage(setting.getDriver());
        SidebarPage sidebarPage = new SidebarPage(setting.getDriver());
        AgentsPage agentsPage = new AgentsPage(setting.getDriver());
        AddNewAgentPage addNewAgentPage = new  AddNewAgentPage(setting.getDriver());
        Actions actions =  new Actions(setting.getDriver());
        loginPage.logIn();
        sidebarPage.openAgentsPage();
        agentsPage.openNewAgentForm();
        addNewAgentPage.fillAgentForm("Marek","Kondrat","example123@wp.pl","500200300");



    }



}