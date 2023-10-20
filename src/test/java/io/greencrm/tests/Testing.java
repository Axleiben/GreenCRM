package io.greencrm.tests;

import io.greencrm.pages.AgentsPage;
import io.greencrm.pages.LoginPage;
import io.greencrm.pages.SidebarPage;
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


        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://test.greencrm.dev");
        driver.manage().window().maximize();


        LoginPage loginPage = new LoginPage(driver);
        SidebarPage sidebarPage = new SidebarPage(driver);
        AgentsPage agentsPage = new AgentsPage(driver);
        Actions actions =  new Actions(driver);
        loginPage.logIn();
        sidebarPage.openAgentsPage();
        agentsPage.setActiveStatus();



//    Optional<WebElement> element=  driver.findElements(By.xpath("//tbody/tr/td/div/span[@class='editItemText_e7aMq']"))
//            .stream()
//            .findFirst();
//            element.ifPresent(e -> actions.moveToElement(e).perform());
//
//            //driver.findElements(By.xpath("//tbody/tr/td/div[text()='Edytuj']")).stream().findFirst().ifPresent(WebElement::click);
//
//
//   driver.findElements(By.xpath("//tbody/tr/td/div/span[@aria-label='edit']")).stream().findFirst().ifPresent(WebElement::click);

    }



}