package io.greencrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgentsPage extends BasePage {

    @FindBy(xpath ="//button/span[text()=\"Dodaj nowego agenta\"]" )
        private WebElement addNewAgentButton;

    @FindBy(name="fullName" )
    private WebElement findAgentInput;

    @FindBy(xpath = "//tr[2]/td[5]/div")
        private WebElement editButton;

    @FindBy(className = "editItemBox_1uaU4'")
        private WebElement changeAccountStatusButton;

    @FindBy(xpath ="//div/span[@class='ant-select-selection-search']" )
        private WebElement statusDropdown;

    @FindBy(xpath = "//div[@label='Aktywne']" )
        private WebElement activeStatus;

    @FindBy(xpath = "//div[@label='Nieaktywowane']" )
    private WebElement inactiveStatus;

    @FindBy(xpath = "//div[@label='Zablokowane']" )
    private WebElement blockedStatus;

    @FindBy(css = "button[class='ant-btn ant-btn-primary ant-btn-lg']")
    private WebElement filterButton;


     public AgentsPage (WebDriver driver) {
         super(driver);
         PageFactory.initElements(driver,this);}

    public void openNewAgentForm(){

         addNewAgentButton.click();
    }

    public void findAgent(String agentName ){

         findAgentInput.sendKeys(agentName);
    }


    public void openAgentEditForm(){

         editButton.click();
    }

    public void openAccountChangeStatusWindow(){

         changeAccountStatusButton.click();
    }

    public void searchingStatus(String status){
         statusDropdown.click();

         switch(status){
             case "Aktywne":
                 activeStatus.click();
                break;
             case "Nieakatywne":
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
}
