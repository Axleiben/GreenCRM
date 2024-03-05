package io.greencrm.pages;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
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
    public void quit(WebDriver firefoxDriver){
        firefoxDriver.quit();
    }

}
