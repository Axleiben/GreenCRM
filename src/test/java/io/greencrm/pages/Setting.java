package io.greencrm.pages;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import java.util.concurrent.TimeUnit;

public class Setting {
    private final String  test = "https://test.greencrm.dev/dashboard";


    public void firefoxSetting(WebDriver firefoxDriver){

        firefoxDriver.get(test);
        firefoxDriver.manage().window().maximize();

        FirefoxOptions options = new FirefoxOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        firefoxDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public void chromeSetting(WebDriver chromedriver){

        chromedriver.get(test);
        chromedriver.manage().window().maximize();

        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public void quit(WebDriver firefoxDriver){
        firefoxDriver.quit();
    }



}
