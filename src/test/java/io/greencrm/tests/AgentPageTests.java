package io.greencrm.tests;

import io.greencrm.pages.AddNewAgentPage;
import io.greencrm.pages.AgentsPage;
import io.greencrm.pages.LoginPage;
import io.greencrm.pages.SidebarPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class AgentPageTests {
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
    public void search_agent_by_name(){
        loginPage.logIn();
        sidebarPage.goToAgentsPage();
        agentsPage.findAgent("Marek");
        agentsPage.clickOnFilterButton();

    }
}
