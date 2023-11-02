package java_Selenium_automation;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser_Chrome_Initialization {
    public static void main(String[] args){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        // Instantiate a ChromeDriver class.
        ChromeDriver driver = new ChromeDriver(options);

        // Maximize the browser
        driver.manage().window().maximize();

        // Launch Website
        driver.get("http://www.automationpractice.pl/index.php");
        //Get the Title of the page
        String page_title = driver.getTitle();
        System.out.println("Title is :" + page_title);
        //close the driver
        driver.close();
    }

}
