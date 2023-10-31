package io.greencrm.tests;

import io.greencrm.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;


public class AddNewAgentTest {

    @Test

    public void addNewAgentTest_1(){

        Setting setting = new Setting();
        setting.setFirefoxSettings();

        LoginPage  loginPage =  new LoginPage(setting.getFirefoxDriver());
        SidebarPage sidebarPage = new SidebarPage(setting.getFirefoxDriver());
        AgentsPage agentsPage = new AgentsPage(setting.getFirefoxDriver());
        AddNewAgentPage addNewAgentPage = new AddNewAgentPage(setting.getFirefoxDriver());

        loginPage.logIn();

        sidebarPage.openAgentsPage();

        agentsPage.openNewAgentForm();


        addNewAgentPage.fillAgentForm("Marek","Kondrat","example123@wp.pl","100200300");

        String success = setting.getFirefoxDriver().findElement(By.className("ant-notification-notice-message")).getText();

        Assert.assertEquals("Operacja powiodła się",success);

    }
    @Test
    public void addNewAgentTest_2(){

        Setting setting = new Setting();
        setting.setFirefoxSettings();

        LoginPage  loginPage =  new LoginPage(setting.getFirefoxDriver());
        SidebarPage sidebarPage = new SidebarPage(setting.getFirefoxDriver());
        AgentsPage agentsPage = new AgentsPage(setting.getFirefoxDriver());
        AddNewAgentPage addNewAgentPage = new AddNewAgentPage(setting.getFirefoxDriver());

        loginPage.logIn();

        sidebarPage.openAgentsPage();

        agentsPage.openNewAgentForm();

        addNewAgentPage.setFirstName("Marek");
        //addNewAgentPage.setLastName("Kondrat");
        addNewAgentPage.setEmail("aaa@wp.pl");
        addNewAgentPage.setPhoneNumber("100200300");
        addNewAgentPage.clickOnSubmitButton();

        ////String validation = setting.getFirefoxDriver().findElement(By.className("ant-col.ant-form-item-control")).getText();
        ///System.out.println(validation);
        String element =   setting.getFirefoxDriver().findElement(By.xpath("//div[@role='alert']")).getText();

        System.out.println(element);
        Assert.assertEquals("Pole jest wymagane",element);

    }
}
