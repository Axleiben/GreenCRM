package io.greencrm.tests;

import io.greencrm.pages.LoginPage;

import io.greencrm.pages.SidebarPage;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Testing {
@Test
    public void testPage(){

                System.setProperty("webdriver.chrome.driver","C:\\Users\\Michał\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver.get("https://test.greencrm.dev/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn();

        SidebarPage sidebarPage = new SidebarPage(driver);
        sidebarPage.openTaskPage();
        sidebarPage.openOwnersPage();
        sidebarPage.openAgentsPage();
        sidebarPage.opentradersPage();
        sidebarPage.openAssemblersPage();
        sidebarPage.openCustomersPage();
        sidebarPage.openAgreementsPage();
        sidebarPage.openInstallationsPage();
        sidebarPage.openMaintenancePage();
        sidebarPage.openCalendarPage();
        sidebarPage.openCalendarPage();
        sidebarPage.openTargetsPage();
        sidebarPage.openProjectsPage();
        sidebarPage.openFilesrepoPage();
        sidebarPage.openSalesSettingsPage();
        sidebarPage.openHelpPage();
        sidebarPage.openContactPage();
        sidebarPage.openDashboardPage();

    }


}
