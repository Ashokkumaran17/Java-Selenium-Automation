package basic_java_selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TimeoutException;

import java.time.Duration;

public class GetKeyword {
    public static void main (String[] arg) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\SSDADMIN\\driver\\chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("https://google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.close();

    }

}
