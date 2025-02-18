package io.greencrm.tests;

import io.greencrm.pages.AddNewAgentPage;
import io.greencrm.pages.AgentsPage;
import io.greencrm.pages.LoginPage;
import io.greencrm.pages.SidebarPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import javax.swing.*;
import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class AgentPageTests {
    private WebDriver driver;
    private SoftAssert softAssert;
    private LoginPage loginPage;
    private SidebarPage sidebarPage;
    private AgentsPage agentsPage;
    private AddNewAgentPage addNewAgentPage;
    private WebDriverWait wait;

    private Actions action;

    @BeforeEach
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-search-engine-choice-screen");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        sidebarPage = new SidebarPage(driver);
        agentsPage = new AgentsPage(driver);
        addNewAgentPage = new AddNewAgentPage(driver);
        softAssert = new SoftAssert();
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        action = new Actions(driver);
    }

//    @AfterTest
//    public void quit()
//    {driver.quit();}

    @Test
    public void search_agent_by_name() {
        loginPage.logIn();
        sidebarPage.goToAgentsPage();
        agentsPage.findAgent("Marek");
        agentsPage.clickOnFilterButton();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody")));

        List<WebElement> row = driver.findElements(By.xpath("//tbody"));

        for (WebElement el : row) {
            System.out.println(el.getText());
        }

        Optional<WebElement> foundElement = row.stream()
                .filter(el -> el.getText().contains("Marek Kondrat"))
                .findFirst();

        Assertions.assertTrue(foundElement.isPresent(),"Searched agent not found");
    }

    @Test
    public void change_agent_status_blocked(){
        loginPage.logIn();
        sidebarPage.goToAgentsPage();
;
        action.moveToElement(agentsPage.getChangeAccountStatusButton()).perform();
        wait.until(ExpectedConditions.elementToBeClickable(agentsPage.getChangeAccountStatusButton()));
        action.moveToElement(agentsPage.getPenButton()).perform();

        agentsPage.openAccountChangeStatusWindow();
        wait.until(ExpectedConditions.elementToBeClickable(agentsPage.getModalChangeStatus()));
        agentsPage.clickOnModalStatusButton();
        //agentsPage.clickOnModalSaveButton();

        WebElement text = driver.findElement(By.xpath("//div[@class =\"ant-col ant-col-14\"]/span[2]"));
        System.out.println(text.getText());

    }
}
