package io.greencrm.pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected final WebDriver driver;
    protected String testUrl ="https://test.greencrm.dev/";

    public  String getTestUrl() {
        return testUrl;
    }

    protected BasePage(WebDriver driver){
        this.driver = driver;

    }





}
