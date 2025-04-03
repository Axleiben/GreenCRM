package io.greencrm.tests;

import io.greencrm.pages.FilesRepoPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FilesRepoTest extends BaseTest {

   private FilesRepoPage filesRepoPage;

    @BeforeEach
    public void initial(){
        filesRepoPage = new FilesRepoPage(driver);
}

    @Test
    public void add_file_to_repo(){

    loginPage.logIn();
    sidebarPage.openFilesrepoPage();
    filesRepoPage.clickOnaddFileButton();
    filesRepoPage.getDragAndDropBInput().sendKeys("C:\\Users\\Michał\\IdeaProjects\\GreenCRM\\screenshots\\login_test_positive()09-03-2025 07-21-14.png");
    filesRepoPage.clickOnAllCheckbox();
    filesRepoPage.clickOnSubmitButton();

}
}
