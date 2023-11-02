package java_Selenium_automation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
class Browser{
    public void Initialize_chrome() {
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
    public void Initialize_edge() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--incognito");
        // Instantiate a ChromeDriver class.
        EdgeDriver driver = new EdgeDriver(options);
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
    public void Initialize_firefox() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--incognito");
        // Instantiate a ChromeDriver class.
        FirefoxDriver driver = new FirefoxDriver(options);
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
public class Cross_Browser_Initialization {
    public static void main(String[] args){

        Browser new_browser = new Browser();
        new_browser.Initialize_chrome();
        new_browser.Initialize_edge();
        new_browser.Initialize_firefox();

    }

}
