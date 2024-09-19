package io.greencrm.tests;

import io.greencrm.pages.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.*;


import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Testing   {

    WebDriver driver;
    @BeforeEach
    public void setup()
    {  ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-search-engine-choice-screen");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);



    }
    @Test
    public void testPage()  {

    LoginPage loginPage = new LoginPage(driver);
    SidebarPage sidebarPage = new SidebarPage(driver);
    AgentsPage agentsPage = new AgentsPage(driver);

    loginPage.logIn();
    sidebarPage.goToAgentsPage();

    WebElement tabela = driver.findElement(By.className("ant-table-tbody"));
        List<WebElement> wiersze = tabela.findElements(By.tagName("tr"));

        for(WebElement wiersz : wiersze){
            System.out.println(wiersz.getText());
        }




    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    WebElement notification = driver.findElement(By.className("ant-notification-notice-description"));

    String notificationText = notification.getText();

    System.out.println(notificationText);
    Assertion assertion = new Assertion();
   assertion.assertEquals(notificationText,"Podany e-mail istnieje już w systemie");




    }



}