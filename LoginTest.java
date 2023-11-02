package basic_java_selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    public static void main (String[] arg) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\SSDADMIN\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Enter username
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.click();
        username.sendKeys("admin");

        //Enter the Password
        WebElement pwd = driver.findElement(By.xpath("//input[@name='password']"));
        pwd.click();
        pwd.sendKeys("admin123");
        //click Login Button
        WebElement login = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
        login.click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("Welcome to OrangeHRM Dashboard!!!");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.quit();


    }

}
