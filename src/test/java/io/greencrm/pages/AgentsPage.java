package io.greencrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class AgentsPage extends BasePage {

    @FindBy(xpath = "//button/span[text()=\"Dodaj nowego agenta\"]")
    private WebElement addNewAgentButton;

    @FindBy(name = "fullName")
    private WebElement findAgentInput;

    @FindBy(xpath = "//tr[2]/td[5]/div")
    private WebElement editButton;

    @FindBy(className = "editItemText_e7aMq")
    private WebElement changeAccountStatusButton;

    @FindBy(xpath = "//div/span[@class='ant-select-selection-search']")
    private WebElement statusDropdown;

    @FindBy(xpath = "//div[@label='Aktywne']")
    private WebElement activeStatus;

    @FindBy(xpath = "//div[@label='Nieaktywowane']")
    private WebElement inactiveStatus;

    @FindBy(xpath = "//div[@label='Zablokowane']")
    private WebElement blockedStatus;

    @FindBy(css = "button[class='ant-btn ant-btn-primary ant-btn-lg']")
    private WebElement filterButton;

    @FindBy(className = "editedTradersItemIcon_1o5h_")
    private WebElement penButton;

    @FindBy(className = "ant-btn-link")
    private WebElement modalChangeStatus;

    @FindBy(xpath = "//button[@class =\"ant-btn ant-btn-lg\"]")
    private WebElement modalCancelButton;

    @FindBy(xpath = "//div[@class =\"ant-modal-footer\"]/button[@class =\"ant-btn ant-btn-primary ant-btn-lg\"]")
    private WebElement modalSaveButton;


    public AgentsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToNewAgentForm() {

        this.addNewAgentButton.click();
    }

    public void findAgent(String agentName) {

        this.findAgentInput.sendKeys(agentName);
    }


    public void openAgentEditForm() {

        this.editButton.click();
    }

    public void openAccountChangeStatusWindow() {

        this.penButton.click();
    }

    public WebElement getChangeAccountStatusButton() {
        return changeAccountStatusButton;
    }

    public void searchingStatus(String status) {
        statusDropdown.click();

        switch (status) {
            case "Aktywne":
                activeStatus.click();
                break;
            case "Nieaktywne":
                inactiveStatus.click();
                break;
            case "Zablokowane":
                blockedStatus.click();
                break;
            default:
                System.out.println("Zła nazwa statusu");
                break;
        }

        filterButton.click();
    }

    public void clickOnFilterButton() {
        this.filterButton.click();
    }

    public WebElement getPenButton() {
        return penButton;
    }

    public void clickOnModalStatusButton() {
        this.modalChangeStatus.click();
    }

    public void clickOnModalCancelButton() {
        this.modalCancelButton.click();
    }

    public void clickOnModalSaveButton() {
        this.modalSaveButton.click();
    }

    public WebElement getModalChangeStatus() {
        return modalChangeStatus;
    }

    public WebElement getModalCancelButton() {
        return modalCancelButton;
    }

    public WebElement getModalSaveButton() {
        return modalSaveButton;
    }
}


