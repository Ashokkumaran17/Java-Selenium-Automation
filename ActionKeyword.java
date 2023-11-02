package basic_java_selenium;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
public class ActionKeyword {
     public static void main(String[] args) {

        // Set Path of Gecko driver
        //System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
         System.setProperty("webdriver.chrome.driver", "C:\\Users\\SSDADMIN\\driver\\chromedriver.exe");

        // Launch Forefox
        WebDriver driver = new ChromeDriver();

        // Open Techlcistic.com's practice form
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        // Set Implicit Wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Maximize Window
        driver.manage().window().maximize();

        // Store Location of Firstname in Webelement
        WebElement FIRSTNAME = driver.findElement(By.name("firstname"));

        // KeyUP and KeyDown
        // Create object of Actions class
        Actions actions = new Actions(driver);

        // This will type Username in Uppercase as we are typing using Shift key pressed
        actions.keyDown(Keys.SHIFT)
                .sendKeys(FIRSTNAME, "Ashokkumar R")
                .keyUp(Keys.SHIFT)
                .build()
                .perform();

    }
}
