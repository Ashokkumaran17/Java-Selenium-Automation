package basic_java_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;


import java.time.Duration;

public class DropDownKeyword {
    public static void main (String[] arg) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\SSDADMIN\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //Click Checkbox Button

        //DropDown Selection
        Select objSelect_text = new Select(driver.findElement(By.xpath("//select[@name='country']")));
        //Select objSelect = new Select(driver.findElement(By.id("dropdownMenuButton")));
        objSelect_text.selectByVisibleText("ANGOLA");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //DropDown Selection
        Select objSelect_index = new Select(driver.findElement(By.xpath("//select[@name='country']")));
        objSelect_index.selectByIndex(2);
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));

        //DropDown Selection
        Select objSelect_value = new Select(driver.findElement(By.xpath("//select[@name='country']")));
        objSelect_value.selectByValue("ALBANIA");
        //WebElement dropdown_ele = driver.findElement(By.xpath("//select[@name='country']"));
        //dropdown_ele.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        //Select dropdown_ele = new Select(driver.findElement(By.xpath("//button[@id='btnGroupDrop1")));
        //dropdown_ele.selectByVisibleText("Dropdown link 1");
        //close the driver
        driver.quit();

    }
}
