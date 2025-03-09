package io.greencrm.tests;

import io.greencrm.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.Assertion;


public class LoginaPageTest extends BaseTest {

     LoginPage loginPage ;

    @BeforeEach
    public void initial() {
        loginPage = new LoginPage(driver);
    }

    @Test
            public void login_test_positive(){

        loginPage.logIn();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header//span[@class='ant-typography text_2gWbH' and text()='Melania Domagała']")));
        String text = driver.findElement(By.xpath("//header//span[@class='ant-typography text_2gWbH' and text()='Melania Domagała']")).getText();
        assertion.assertEquals(text,"Melania Domagała","Wrong account or login not success");
    }
    @Test
    public void wrong_login_should_be_correct_message()  {

        driver.get(testUrl);
        loginPage.getLoginInput().sendKeys("fdsfd");
        loginPage.setPassword("Avocado1357!#");
        loginPage.loginButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-notification-notice-description")));

        String text = driver.findElement(By.className("ant-notification-notice-description")).getText();
        assertion.assertEquals(text,"Błędny login lub hasło","wrong bad login message");

    }

    @Test
    public void wrong_password_should_be_correct_message(){
        loginPage.setLogin("Melania@wp.pl");
        loginPage.setPassword("Aaaaaaaa");
        loginPage.loginButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-notification-notice-description")));

        String text = driver.findElement(By.className("ant-notification-notice-description")).getText();
        Assertion assertion = new Assertion();
        assertion.assertEquals(text,"Błędny login lub hasło","wrong bad login message");


    }

}
