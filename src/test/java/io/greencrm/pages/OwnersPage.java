package io.greencrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OwnersPage {

    @FindBy(xpath = "//button/span[text()=\"Dodaj nowego właściciela\"]")
    private WebElement addNewOwnerButton;

    @FindBy( css="[class='icon-green']")
    private WebElement accountStatusButton;

    @FindBy(css = "[class='anticon anticon-edit editedTradersItemIcon_1o5h_'")
    private  WebElement editAccountStatusButton;

    @FindBy(css = "ant-btn ant-btn-link")
    private  WebElement changeStatusButton;

    @FindBy(css = "ant-btn ant-btn-primary ant-btn-lg")
    private WebElement changeStatusConfirmButton;

    public OwnersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void changeAccountStatus(WebDriver driver){

        Actions action = new Actions(driver);
        action.moveToElement(accountStatusButton);
        changeStatusButton.click();
        changeStatusConfirmButton.click();
    }

        public void addingNewOwnerButton() { addNewOwnerButton.click();}



}
