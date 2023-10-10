package io.greencrm.tests;

import io.greencrm.pages.*;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

    driver.findElements(By.xpath("//tbody/tr/td/div[@class='hyperlink']")).stream().findFirst().ifPresent(WebElement::click);



        //driver.findElements(By.xpath("//tbody/tr/td")).stream().filter(el -> el.isDisplayed()).findAny();









    }



}
