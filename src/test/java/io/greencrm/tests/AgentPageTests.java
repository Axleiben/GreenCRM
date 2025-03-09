package io.greencrm.tests;

import io.greencrm.pages.AgentsPage;
import io.greencrm.pages.LoginPage;
import io.greencrm.pages.SidebarPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Optional;

public class AgentPageTests extends BaseTest {

    private LoginPage loginPage;
    private SidebarPage sidebarPage;
    private AgentsPage agentsPage;




    @BeforeEach
    public void initial() {
        loginPage = new LoginPage(driver);
        sidebarPage = new SidebarPage(driver);
        agentsPage = new AgentsPage(driver);

    }

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
