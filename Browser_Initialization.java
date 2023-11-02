package java_Selenium_automation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser_Initialization {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","C:\\Chromedriver\\chromedriver.exe");
        // Instantiate a ChromeDriver class.
        WebDriver driver = new ChromeDriver();

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
