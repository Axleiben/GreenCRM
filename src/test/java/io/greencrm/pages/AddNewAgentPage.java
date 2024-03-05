package io.greencrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewAgentPage {
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

    public AddNewAgentPage (WebDriver driver) {
        PageFactory.initElements(driver,this);}

    public void fillNewAgentForm(String firstName, String lastName, String email, String phoneNumber ) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        phoneInput.sendKeys(phoneNumber);

    }

}

