package io.greencrm.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id="login_email")
    private WebElement loginInput;

    @FindBy(id = "login_password")
    private WebElement passwordInput;

    @FindBy(css ="[class='ant-btn ant-btn-primary ant-btn-lg button_3va6S']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }



    public void logIn(){
        this.loginInput.sendKeys("cenniksolin@www.pa");
        this.passwordInput.sendKeys("Avocado1!");
        this.loginButton.click();
    }
}
