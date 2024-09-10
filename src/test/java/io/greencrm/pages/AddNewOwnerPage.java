package io.greencrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewOwnerPage extends BasePage {

    @FindBy (css = "input[name=firstName]")
    private WebElement firstNameInput;

    @FindBy (css = "input[name=lastName]")
    private WebElement lastNameInput;

    @FindBy (css = "input[name=email]")
    private WebElement emailInput;

    @FindBy (css = "input[name=phoneNumber]")
    private WebElement phoneNumberInput;

    @FindBy (css = "input[name=sendChangePasswordMail]")
    private WebElement sendEmailChceckbox;

    @FindBy (css = "button[type=submit]")
    private WebElement submitButton;


    public  AddNewOwnerPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);}

    public void setFirstName (String firstName){
            firstNameInput.sendKeys(firstName);
        }
    public void setLastName  (String lastName){
        lastNameInput.sendKeys(lastName);
    }
    public void setEmail  (String email){
        emailInput.sendKeys(email);
    }
    public void setPhoneNumberInput  (String phoneNumber){
        phoneNumberInput.sendKeys(phoneNumber);
    }
    public void setSendEmailChceckbox  (){
        sendEmailChceckbox.click();
    }

    public void AddingNewOwner  (){
        submitButton.click();
    }

}

