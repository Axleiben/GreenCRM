package io.greencrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewAgentPage  {
    @FindBy(name ="firstName")
    private WebElement firstNameInput;

    @FindBy(name ="lastName")
    private  WebElement lastNameInput;

    @FindBy( name = "email")
    private  WebElement emailInput;

    @FindBy(name = "phoneNumber")
    private  WebElement phoneInput;

    @FindBy(name= "sendChangePasswordMail")
    private WebElement mailCheckbox;

    @FindBy(css = "#control-hooks > div > div > div:nth-child(2) > button")
    private WebElement submitButton;

    public AddNewAgentPage (WebDriver driver) {
        PageFactory.initElements(driver,this);}

    public void fillNewAgentForm(String firstName, String lastName, String email, String phoneNumber ) {
        this.firstNameInput.sendKeys(firstName);
        this.lastNameInput.sendKeys(lastName);
        this.emailInput.sendKeys(email);
        this.phoneInput.sendKeys(phoneNumber);

    }
    public void markSendEmailChceckbox(){
        this.mailCheckbox.click();
    }
    public void submittingNewAgentForm(){
        this.submitButton.click();
    }

}

