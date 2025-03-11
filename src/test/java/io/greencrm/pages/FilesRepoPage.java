package io.greencrm.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilesRepoPage extends BasePage {

    @FindBy(css=".ant-row .addDocumentBtn_3stKU button[class =\"ant-btn ant-btn-primary ant-btn-lg\"]")
    private WebElement addFileButton;

    @FindBy (css ="input[type =\"file\"]")
    private WebElement dragAndDropBInput;

    @FindBy (css ="button[data-cy =\"upload-button\"]")
    private  WebElement uploadButton;

    @FindBy(css ="input[name ='availableForAll']")
    private WebElement allCheckbox;
    @FindBy(css ="button[data-cy ='submit']")
    private WebElement submitButton;

    public  FilesRepoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements( driver,this);}

    public void clickOnaddFileButton(){
        this.addFileButton.click();
    }

    public void clickOnadduploadButton(){
        this.uploadButton.click();
    }

    public void clickOnAllCheckbox(){
        this.allCheckbox.click();
    }

    public void clickOnSubmitButton(){
        this.submitButton.click();
    }

    public WebElement getDragAndDropBInput() {
        return dragAndDropBInput;
    }

}