package io.greencrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewAgentPage {

    @FindBy(name= "firstName")
    private WebElement firstNameInput;

    @FindBy(name = "lastName")
    private WebElement lastNameInput;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy (className = "ant-checkbox")
    private WebElement checkBox;

    @FindBy(name = "phoneNumber")
    private WebElement phoneNumberInput;

    @FindBy (css = "button[type=submit]")
    private WebElement submitButton;

    public  AddNewAgentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);}

    public void setFirstName(String firstName) {
      firstNameInput.sendKeys(firstName); ;
    }

    public void setLastName(String lastName) {
        lastNameInput.sendKeys(lastName); ;
    }

    public void setEmail(String email) {
        emailInput.sendKeys(email); ;
    }

    public void setPhoneNumber(String phoneNumber) {
        phoneNumberInput.sendKeys(phoneNumber); ;
    }

    public void clickOnSendEmailChceckbox(){
        checkBox.click();
    }

    public void clickOnSubmitButton(){
        submitButton.click();
    }
    public void fillAgentForm(String firstName, String lastName, String email, String phoneNumber) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        phoneNumberInput.sendKeys(phoneNumber);
        submitButton.click();
    }
}
