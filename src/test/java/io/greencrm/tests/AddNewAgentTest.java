package io.greencrm.tests;

import io.greencrm.pages.AddNewAgentPage;
import io.greencrm.pages.AgentsPage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class AddNewAgentTest  extends BaseTest{

    private AgentsPage agentsPage ;
    private AddNewAgentPage addNewAgentPage;


    @BeforeEach
    public void initial()
    {
         agentsPage = new AgentsPage(driver);
         addNewAgentPage = new AddNewAgentPage(driver);
    }

  @Test
 public void email_exists_should_not_create_new_agent()  {

      loginPage.logIn();
        sidebarPage.goToAgentsPage();
        agentsPage.goToNewAgentForm();
        addNewAgentPage.fillNewAgentForm("Jan",
                                        "Kowalski",
                                        "example@wp.pls",
                                        "1000200300");
        addNewAgentPage.markSendEmailChceckbox();
        addNewAgentPage.submittingNewAgentForm();

        WebElement notification = driver.findElement(By.className("ant-notification-notice-content"));

        String notificationText = notification.getText();
        System.out.println(notificationText);
        assertion.assertEquals(notificationText, "Błąd\n" +
                "Podany e-mail istnieje już w systemie");
    }

@Test
 public void name_input_validation_should_show_proper_notification(){

        loginPage.logIn();
        sidebarPage.goToAgentsPage();
        agentsPage.goToNewAgentForm();
        addNewAgentPage.getFirstNameInput().sendKeys("a");
        addNewAgentPage.submittingNewAgentForm();
        String moreThanTwoSignsError = driver.findElement(By.className("ant-form-item-explain-error")).getText();
        softAssert.assertEquals(moreThanTwoSignsError,"Pole powinno składać się z co najmniej 2 znaków","Komunikat bledu jest nieprawidlowy");
        addNewAgentPage.getFirstNameInput().clear();

        addNewAgentPage.getFirstNameInput().sendKeys("23");
        String onlyLettersError = driver.findElement(By.className("ant-form-item-explain-error")).getText();
        softAssert.assertEquals(onlyLettersError,"Pole może składać się jedynie z liter","Komunikat bledu jest nieprawidlowy");
        addNewAgentPage.getFirstNameInput().sendKeys(Keys.CONTROL + "a" +Keys.DELETE);

        addNewAgentPage.fillFirstNameInput("   ");
        String noWhiteSignsError = driver.findElement(By.className("ant-form-item-explain-error")).getText();
        softAssert.assertEquals(noWhiteSignsError,"Pole nie może składać się z pustych znaków","Komunikat bledu jest nieprawidlowy");

        softAssert.assertAll();
    }

}
