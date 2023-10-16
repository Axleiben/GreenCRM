package io.greencrm.tests;

import io.greencrm.pages.*;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Actions;



public class Testing {
@Test
    public void testPage(){


        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://test.greencrm.dev");
        driver.manage().window().maximize();


        LoginPage loginPage = new LoginPage(driver);
        SidebarPage sidebarPage = new SidebarPage(driver);

        loginPage.logIn();

        //driver.findElement(By.cssSelector("a[href='/agents']")).click();

       sidebarPage.openAgentsPage();

    //driver.findElements(By.xpath("//tbody/tr/td/div[text()='Edytuj']")).stream().findFirst().ifPresent(WebElement::click);
        AgentsPage agentsPage = new AgentsPage(driver);

        agentsPage.openEditForm();












    }



}
