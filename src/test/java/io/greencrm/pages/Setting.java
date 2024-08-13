package io.greencrm.pages;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class Setting {


   // WebDriver chromeDriver= new ChromeDriver();
    WebDriver firefoxDriver = new FirefoxDriver();

    String test ="https://test.greencrm.dev/";
    String preprod = "https://preprod.greencrm.io/";

//    public void setChromeSettings() {
//
//
//
//        ChromeOptions options = new ChromeOptions();
//        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
//
//        chromeDriver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
//        chromeDriver.manage().window().maximize();
//        chromeDriver.get(test);
//
//    }

    public void setFirefoxSettings() {


        FirefoxOptions options = new FirefoxOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);

        firefoxDriver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        firefoxDriver.manage().window().maximize();
        firefoxDriver.get(test);

    }

//    public WebDriver getChromeDriver() {
//        return chromeDriver;
//    }

    public WebDriver getFirefoxDriver() {
        return firefoxDriver;
    }

}