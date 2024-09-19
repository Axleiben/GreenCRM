package io.greencrm.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage  extends BasePage{

    @FindBy(id="login_email")
    private WebElement loginInput;

    @FindBy(id = "login_password")
    private WebElement passwordInput;

    @FindBy(css ="[class='ant-btn ant-btn-primary ant-btn-lg button_3va6S']")
    private WebElement loginButton;

    @FindBy(className = "ant-notification-notice-close")
    private WebElement notification;



    protected final String login ="Melania@wp.pl";
    protected final String password ="Avocado1357!#";


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);

    }


    public void logIn(){
       driver.get(getTestUrl());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.loginInput.sendKeys(login);
        this.passwordInput.sendKeys(password);
        this.loginButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(this.notification)).click();
    }

    public void setLogin(String login){
        this.loginInput.sendKeys(login);
    }

    public WebElement getLoginInput() {
        return loginInput;
    }

    public void setPassword(String password){
        this.passwordInput.sendKeys(password);
    }

    public void loginButton(){
        loginButton.click();
    }

}
