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


import javax.crypto.spec.PSource;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;


public class Testing   {

    private WebDriver driver;
    private SoftAssert softAssert;
    private LoginPage loginPage;
    private SidebarPage sidebarPage;
    private AgentsPage agentsPage ;
    private AddNewAgentPage addNewAgentPage;

    @BeforeEach
    public void setup()
    {  ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-search-engine-choice-screen");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        sidebarPage = new SidebarPage(driver);
        agentsPage = new AgentsPage(driver);
        addNewAgentPage = new AddNewAgentPage(driver);
        softAssert = new SoftAssert();


    }

    @Test
    public void testPage()  {

    loginPage.logIn();
    sidebarPage.goToAgentsPage();

    WebElement tabela = driver.findElement(By.className("ant-table-tbody"));
        List<WebElement> wiersze = tabela.findElements(By.tagName("tr"));

        for(WebElement wiersz : wiersze){
            System.out.println(wiersz.getText());
        }
        Optional<WebElement> editButton = wiersze.stream()
                .filter(e -> e.getText().contains("Edytuj")) // Sprawdzanie, czy tekst wiersza zawiera "Edytuj"
                .findFirst();


        System.out.println(editButton);

        WebElement ed = driver.findElement(By.linkText("Edytuj"));
        System.out.println(ed);

    }

}