import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Testing {
@Test
    public void testPage(){

                System.setProperty("webdriver.chrome.driver","C:\\Users\\Michał\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://test.greencrm.dev");

        driver.findElement(By.id("login_email")).sendKeys("Lila@wp.pl");
        driver.findElement(By.id("login_password")).sendKeys("Avocado1!");
        driver.findElement(By.cssSelector("[class='ant-btn ant-btn-primary ant-btn-lg button_3va6S']")).click();



    }

}
