package basic_java_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

import java.time.Duration;

public class WaitKeyword {
    public static void main (String[] arg) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\SSDADMIN\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement name = driver.findElement(By.name("Login"));

        Assert.assertEquals(name.getText(),"Login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.quit();


    }
}
