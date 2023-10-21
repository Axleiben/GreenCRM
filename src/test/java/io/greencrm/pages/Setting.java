package io.greencrm.pages;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Setting {
    WebDriver driver = new ChromeDriver();
    public void useSettings() {

    String test ="https://test.greencrm.dev/";
    String preprod = "https://preprod.greencrm.io/";
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);

        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get(preprod);
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }
}