package io.greencrm.tests;


import io.greencrm.pages.LoginPage;

import io.greencrm.pages.SidebarPage;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;


public class Testing {
    @Test
    public void testPage() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Michał\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver.get("https://test.greencrm.dev/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn();

        SidebarPage sidebarPage = new SidebarPage(driver);
        sidebarPage.openAgentsPage();


        WebElement statusList =  driver.findElement(By.className("ant-select-selection-search-input"));
        statusList.click();
         Select select = new Select(statusList);
         select.selectByVisibleText("Aktywne");

        System.out.println(statusList);



        //AgentsPage agentsPage = new AgentsPage(driver);
        //agentsPage.findAgent("Krupa");








    }
}
