package java_Selenium_automation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver.Timeouts;
//import this package to use explicit timeout
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
//import ArrayList package used for Switch
import java.util.ArrayList;

import java.time.Duration;

public class Ecom_Web_Page_Automation {
    //declare driver as global variable
    WebDriver driver;
    public static final String email_id = "selenium_java_2023@yopmail.com";
    public static final String First_Name = "John";
    public static final String Last_Name = "Doe";
    public static final String Pwd = "Java2023";
    public static void main(String[] args){
        Ecom_Web_Page_Automation driver_obj = new Ecom_Web_Page_Automation();
        //call Initialize Browser func
        driver_obj.Initialize_the_Browser();
        //call Sign In button
        driver_obj.SignIn_Btn_click();
        //call login func
        driver_obj.Login_test();
        //call the Select menu func
        driver_obj.Select_Menu_Items();

        //call logout the web app
        driver_obj.Logout_test();

        //call close Browser func
        driver_obj.Close_the_Browser();



    }
    public void Initialize_the_Browser(){
        System.setProperty("webdriver.chrome.driver","C:\\Chromedriver\\chromedriver.exe");
        // Instantiate a ChromeDriver class.
        driver = new ChromeDriver();

        // Maximize the browser
        driver.manage().window().maximize();
        //Wait for 30 sec
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        // Launch Website
        driver.get("http://www.automationpractice.pl/index.php");
        //Get the Title of the page
        String page_title = driver.getTitle();
        System.out.println("Title is :" + page_title);
        if (page_title.equals("My Shop")){
            System.out.println("Home page Title Verification passed");
        }else {
            System.out.println("Home page Title Verification Failed!!!");
        }

    }
    public void SignIn_Btn_click(){
        // explicit wait - to wait for the Sign In button to be click-able
        WebDriverWait wait_sign_in_btn = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait_sign_in_btn.until(ExpectedConditions.visibilityOfElementLocated(By.className("login")));
        //Wait for 30 sec
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement sign_in_btn= driver.findElement(By.className("login"));
        sign_in_btn.click();

        // explicit wait - to wait for the create Account button to be click-able
        WebDriverWait wait_account_btn = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait_account_btn.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='create-account_form']")));
        //display the title of the page
        String auth_page_title = driver.getTitle();
        System.out.println("Title is :" + auth_page_title);
        if (auth_page_title.equals("Login - My Shop")){
            System.out.println("Auth Title page verification Passed!!!");
        }else{
            System.out.println("Auth Title page verification failed!!!");
        }


    }
    public void create_account(){
        //After clicking the Create account Button
        //Wait for Gender Selection
        WebDriverWait wait_account_btn = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait_account_btn.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender1")));
        //Click Gender
        WebElement select_gender = driver.findElement(By.id("id_gender1"));
        select_gender.click();
        //Enter the First name
        WebElement fName = driver.findElement(By.id("customer_firstname"));
        fName.click();
        fName.sendKeys(First_Name);
        //Enter the Last name
        WebElement lName = driver.findElement(By.id("customer_lastname"));
        lName.click();
        lName.sendKeys(Last_Name);
        //Enter the password
        WebElement user_pwd = driver.findElement(By.id("passwd"));
        user_pwd.click();
        user_pwd.sendKeys(Pwd);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //select the Date of birth from dropdown menu
        Select select_date = new Select(driver.findElement(By.id("days")));
        select_date.selectByIndex(2);
        Select select_month = new Select(driver.findElement(By.id("months")));
        select_month.selectByIndex(3);
        Select select_year = new Select(driver.findElement(By.id("years")));
        select_year.selectByIndex(1);
        //Click the Register Button
        WebElement register_btn = driver.findElement(By.id("submitAccount"));
        register_btn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //Wait for Register alert success message
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='logout']")));
        WebElement logout_btn = driver.findElement(By.xpath("//a[@class='logout']"));
        String text_msg = logout_btn.getText();
        System.out.println("output is "+ text_msg);

        if (text_msg.equalsIgnoreCase("Sign out")){
            System.out.println("Account is created successfully");

        }else {
            System.out.println("Failed to create the Account!!!");

        }

    }
    public void login_with_Existing_Account(){
        //Enter the Email Id
        WebElement usr_email_id = driver.findElement(By.id("email"));
        usr_email_id.click();
        usr_email_id.sendKeys(email_id);
        //Enter the Password
        WebElement usr_pwd = driver.findElement(By.id("passwd"));
        usr_pwd.click();
        usr_pwd.sendKeys(Pwd);
        //Click Submit button
        WebElement submit_btn = driver.findElement(By.id("SubmitLogin"));
        submit_btn.click();
        //div[@id="center_column"]/p[@class="alert alert-success"]
        //WebElement create_account_msg = driver.findElement(By.xpath("//div[@id='center_column']/p[@class='alert alert-success']"));
        WebElement login_success = driver.findElement(By.xpath("//a[@class='logout']"));
        String text_msg = login_success.getText();
        if (text_msg.equalsIgnoreCase("Sign out")){
            System.out.println("Login successful");

        }else {
            System.out.println("Failed to login the Account!!!");

        }
    }
    public void Login_test(){
        //create a account for the first time user
        WebElement create_email = driver.findElement(By.id("email_create"));
        create_email.click();
        //Enter the email id
        create_email.sendKeys(email_id);
        //click Create Account
        WebElement submit_create_acc_btn = driver.findElement(By.id("SubmitCreate"));
        submit_create_acc_btn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='create_account_error']")));
        //Check Account is Exist or not?
        WebElement alert_msg_acc = driver.findElement(By.xpath("//div[@id='create_account_error']/ol/li"));
        String actual_text_msg = alert_msg_acc.getText();
        System.out.println(actual_text_msg);
        if (actual_text_msg.equalsIgnoreCase("An account using this email address has already been registered. Please enter a valid password or request a new one.")){
            System.out.println("Your Email Id is Already Registered on the Application. ");
            //call the login_with_Existing_Account func
            login_with_Existing_Account();

        }else {
            System.out.println("Your Email Id is not Registered on the Application.");
            System.out.println("Please create new account to proceed further.");
            //Call the create_account func
            create_account();

        }

    }
    public void Return_to_Home(){
        WebElement search_box = driver.findElement(By.xpath("//input[@id=\"search_query_top\"]"));
        //Instantiating Action class
        Actions actions = new Actions(driver);
        //To Hovering the Search box
        actions.moveToElement(search_box).build().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement home_icon = driver.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/a/i[@class=\"icon-home\"]"));
        home_icon.click();
    }
    public void category_Tops(){
        //Select the menu using mouse hover operation
        WebElement Women_category_tops = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[1]"));
        //Instantiating Action class
        Actions actions = new Actions(driver);
        //To Hovering the Women category
        actions.moveToElement(Women_category_tops);
        //click the submenu T-shirts
        WebElement submenu_t_shirts = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[1]/a"));
        //To Mouse hover on submenu
        actions.moveToElement(submenu_t_shirts).build().perform();
        submenu_t_shirts.click();
        //Click Home Icon to Return back to Menu
        Return_to_Home();

    }
    public void category_Blouses(){
        WebElement Women_category_blouses = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[1]"));
        //Instantiating Action class
        Actions actions_2 = new Actions(driver);
        //To Hovering the Women category
        actions_2.moveToElement(Women_category_blouses);
        //click the submenu Blouses
        WebElement submenu_blouses = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[2]/a"));
        //To Mouse hover on submenu
        actions_2.moveToElement(submenu_blouses).build().perform();
        submenu_blouses.click();
        Return_to_Home();
    }
    public void display_menu_count(){
        //Count the category
        List<WebElement> menu_count = driver.findElements(By.xpath("//div[@id='block_top_menu']/ul/li"));
        System.out.println("*************************************************");
        System.out.println("No of category in menu: "+ menu_count.size());
        System.out.println("Display the category name on menu:");
        for (int i=0;i<menu_count.size();i++){
            System.out.println(menu_count.get(i).getText());
        }
        System.out.println("*************************************************");
    }
    public void view_casual_dress(){
        //Select the menu using mouse hover operation
        WebElement Dress_category = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[2]"));
        //Instantiating Action class
        Actions actions = new Actions(driver);
        //To Hovering the Dress category
        actions.moveToElement(Dress_category);
        //click the submenu casual Dress
        WebElement submenu_casual_shirts = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[2]/ul/li[1]/a"));
        //To Mouse hover on submenu
        actions.moveToElement(submenu_casual_shirts).build().perform();
        String casual_page_title = submenu_casual_shirts.getText();
        System.out.println("Page title is: "+ casual_page_title);
        submenu_casual_shirts.click();
        //display the image title
        WebElement casual_img_title = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]"));
        String casual_image_title = casual_img_title.getText();
        System.out.println("*************************************************");
        System.out.println("casual image title is: "+ casual_image_title);
        //count no of images in casual dress
        List<WebElement> casual_ele = driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li"));
        System.out.println("casual dress count:" + casual_ele.size());
        System.out.println("casual dress  name is: ");
        for (int i=0;i<casual_ele.size();i++){
            System.out.println(casual_ele.get(i).getText());
        }
        System.out.println("*************************************************");
        //Click Home Icon to Return back to Menu
        Return_to_Home();
    }
    public void view_evening_dress(){
        //Select the menu using mouse hover operation
        WebElement Dress_category = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[2]"));
        //Instantiating Action class
        Actions actions = new Actions(driver);
        //To Hovering the Dress category
        actions.moveToElement(Dress_category);
        //click the submenu evening Dress
        WebElement submenu_evening_shirts = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[2]/ul/li[2]/a"));
        //To Mouse hover on submenu
        actions.moveToElement(submenu_evening_shirts).build().perform();
        String evening_page_title = submenu_evening_shirts.getText();
        System.out.println("*************************************************");
        System.out.println("Page title is: "+ evening_page_title);
        submenu_evening_shirts.click();

        //count no of images in evening dress
        List<WebElement> evening_ele = driver.findElements(By.xpath("//ul[@class=\"product_list grid row\"]/li"));
        System.out.println("evening dress count:" + evening_ele.size());
        System.out.println("*************************************************");
        //Click Home Icon to Return back to Menu
        Return_to_Home();
    }
    public void view_summer_dress(){
        //Select the menu using mouse hover operation
        WebElement Dress_category = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[2]"));
        //Instantiating Action class
        Actions actions = new Actions(driver);
        //To Hovering the Dress category
        actions.moveToElement(Dress_category);
        //click the submenu summer Dress
        WebElement submenu_summer_shirts = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[2]/ul/li[3]/a"));
        //To Mouse hover on submenu
        actions.moveToElement(submenu_summer_shirts).build().perform();
        String summer_page_title = submenu_summer_shirts.getText();
        System.out.println("*************************************************");
        System.out.println("Page title is: "+ summer_page_title);
        submenu_summer_shirts.click();
        //count no of images in evening dress
        List<WebElement> summer_ele = driver.findElements(By.xpath("//ul[@class=\"product_list grid row\"]/li"));
        System.out.println("summer dress count:" + summer_ele.size());
        System.out.println("*************************************************");
        //Click Home Icon to Return back to Menu
        Return_to_Home();
    }
    public void View_TShirts_category(){
        //click T-Shirts on Menu
        WebElement category_t_shirts = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[3]"));
        category_t_shirts.click();
        //count no of images in casual dress
        List<WebElement> t_shirts_ele = driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li"));
        System.out.println("*************************************************");
        System.out.println("t_shirts_ele count:" + t_shirts_ele.size());
        System.out.println("t_shirts_ele  name is: ");
        for (int i=0;i<t_shirts_ele.size();i++){
            System.out.println(t_shirts_ele.get(i).getText());
        }
        System.out.println("*************************************************");
        //Click Home Icon to Return back to Menu
        Return_to_Home();

    }
    public void display_best_seller_counts(){
        //click Best Seller
        WebElement best_seller_btn=driver.findElement(By.xpath("//*[@id=\"home-page-tabs\"]/li[2]/a"));
        best_seller_btn.click();
        List<WebElement> best_seller = driver.findElements(By.xpath("//ul[@id=\"blockbestsellers\"]/li"));
        System.out.println("*************************************************");
        System.out.println("No of counts in BestSeller: "+ best_seller.size());
        System.out.println("Display the category name on menu:");
        for (int i=0;i<best_seller.size();i++){
            System.out.println(best_seller.get(i).getText());
        }
        System.out.println("*************************************************");
    }
    public void View_Blog_category(){
        //Click Blog on Menu
        WebElement category_blog = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[4]"));
        category_blog.click();

        // hold all window handles in array list
        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        //switch to new tab
        driver.switchTo().window(newTb.get(1));
        System.out.println("Page title of new tab: " + driver.getTitle());
        //switch to parent window
        driver.switchTo().window(newTb.get(0));
        System.out.println("Page title of parent window: " + driver.getTitle());

    }
    public void View_Women_category(){
        category_Tops();
        category_Blouses();
    }
    public void View_Dress_category(){
        view_casual_dress();
        view_evening_dress();
        view_summer_dress();

    }
    public void Select_Menu_Items(){
        display_menu_count();
        View_Women_category();
        View_Dress_category();
        View_TShirts_category();
        display_best_seller_counts();
        View_Blog_category();

    }
    public void Logout_test(){
        WebDriverWait wait_logout_btn = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait_logout_btn.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='logout']")));

        //Click Logout btn
        WebElement logout_btn = driver.findElement(By.xpath("//a[@class='logout']"));
        logout_btn.click();
        //Get the Title of the page
        String home_page_title = driver.getTitle();
        System.out.println("*******************************************************");
        System.out.println("Home Page Title is :" + home_page_title);
        if (home_page_title.equals("My Shop")){
            System.out.println("Logout Successful");
        }else {
            System.out.println("Failed to do Logout!!!");
        }
        System.out.println("*******************************************************");

    }

    public void Close_the_Browser(){
        //driver.close();
        driver.quit();
    }
}
