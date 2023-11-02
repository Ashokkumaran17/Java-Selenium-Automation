package basic_java_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;

import java.time.Duration;


public class RadioButtonKeyword {
    public static void main (String[] arg) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\SSDADMIN\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/checkbox");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //Click Checkbox Button
        WebElement checkbox_ele = driver.findElement(By.xpath("//input[@value='checkbox-1']"));
        boolean select = checkbox_ele.isSelected();
        System.out.print(select);
        System.out.print("\n");
        // performing click operation if element is not already selected
        if (select == false){
            checkbox_ele.click();
            System.out.println("Checkbox Enabled");
        }else {
            if(select == true)
            {
                System.out.println("Checkbox Already Enabled !!");
            }else {
                System.out.println("Checkbox Enabled failed!!");
            }
        }

        //close the driver
        driver.quit();

    }

}
