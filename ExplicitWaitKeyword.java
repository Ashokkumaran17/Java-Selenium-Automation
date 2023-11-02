package basic_java_selenium;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWaitKeyword {
    public static void main (String[] arg) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\SSDADMIN\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));

        System.out.println("welcome");
        driver.close();
    }
}
