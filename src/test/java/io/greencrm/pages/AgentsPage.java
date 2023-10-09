package io.greencrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgentsPage {

    @FindBy(xpath ="//button/span[text()=\"Dodaj nowego agenta\"]" )
        private WebElement addNewAgentButton;

    @FindBy(name="fullName" )
    private WebElement findAgentInput;

    @FindBy(xpath = "//tr[2]/td[5]/div")
        private WebElement editButton;

    @FindBy(className = "editItemBox_1uaU4'")
        private WebElement changeAccountStatusButton;

     public AgentsPage (WebDriver driver) {PageFactory.initElements(driver,this);}

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
}
