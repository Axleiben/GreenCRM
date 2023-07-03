package io.greencrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SidebarPage {

    @FindBy(css ="a[href='/tasks']")
    private WebElement taskButton;

    @FindBy(css ="a[href='/owners']")
    private WebElement ownersButton;

    @FindBy(css ="a[href='/agents']")
    private WebElement agentsButton;

    @FindBy(css ="a[href='/traders']")
    private WebElement tradersButton;

    @FindBy(css ="a[href='/assemblers']")
    private WebElement assemblersButton;

    @FindBy(css ="a[href='/customers']")
    private WebElement customersButton;

    @FindBy(css ="a[href='/agreements']")
    private WebElement agreementsButton;

    @FindBy(css ="a[href='/installations']")
    private WebElement installationsButton;

    @FindBy(css ="a[href='/maintenance']")
    private WebElement maintenanceButton;

    @FindBy(css ="a[href='/calendar']")
    private WebElement calendarButton;

    @FindBy(css ="a[href='/targets']")
    private WebElement targetsButton;

    @FindBy(css ="a[href='/projects']")
    private WebElement projectsButton;

    @FindBy(css ="a[href='/filesrepo']")
    private WebElement filesrepoButton;

    @FindBy(css ="a[href='/sales-settings']")
    private WebElement salesSettingsButton;

    @FindBy(css ="a[href='/help']")
    private WebElement helpButton;

    @FindBy(css ="a[href='/contact']")
    private WebElement contactButton;

    @FindBy(css ="a[href='/dashboard']")
    private WebElement dashboardButton;

    public  SidebarPage(WebDriver driver) {PageFactory.initElements(driver,this);}

    public void openTaskPage(){
        taskButton.click();
    }

    public void openOwnersPage(){
        ownersButton.click();
    }

    public void openAgentsPage(){
        agentsButton.click();
    }

    public void opentradersPage(){
        tradersButton.click();
    }

    public void openAssemblersPage(){
        assemblersButton.click();
    }

    public void openCustomersPage(){
        customersButton.click();
    }

    public void openAgreementsPage(){
        agreementsButton.click();
    }

    public void openInstallationsPage(){
        installationsButton.click();
    }

    public void openMaintenancePage(){
        maintenanceButton.click();
    }

    public void openCalendarPage(){
        calendarButton.click();
    }

    public void openTargetsPage(){
        targetsButton.click();
    }

    public void openProjectsPage(){
        projectsButton.click();
    }

    public void openFilesrepoPage(){
        filesrepoButton.click();
    }

    public void openSalesSettingsPage(){
        salesSettingsButton.click();
    }

    public void openHelpPage(){
        helpButton.click();
    }

    public void openContactPage(){
        contactButton.click();
    }

    public void openDashboardPage(){
        dashboardButton.click();
    }
}

