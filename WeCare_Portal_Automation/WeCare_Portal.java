package WeCare_Portal_Automation;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class WeCare_Portal {
    ChromeDriver driver;
    public void InvokeBrowser(){
        System.setProperty("webdriver.chrome.driver","C:\\Chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        //Maximize the browser's screen
        driver.manage().window().maximize();
        driver.get("https://wecare.inspirisys.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    public void UserName_Entry(){
        //Wait for Page to Load
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        WebElement username_Field=driver.findElement(By.name("Username"));
        username_Field.click();
        username_Field.sendKeys("<UserName>");

    }
    public void PassWord_Entry(){
        //Wait for Page to Load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement passWord_Field=driver.findElement(By.id("Password"));
        passWord_Field.click();
        passWord_Field.sendKeys("<Password>");

    }
    public void SignIn_btn_click(){
        WebElement SignInBtn=driver.findElement(By.xpath("//button[@type='submit']"));
        SignInBtn.click();
    }
    public void MenuBtn_click(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gn-menu")));
        WebElement MenuIcon=driver.findElement(By.xpath("//ul[@id=\"gn-menu\"]//a[@title=\"Click here for Menu\"]"));
        Actions mouseHover= new Actions(driver);
        mouseHover.moveToElement(MenuIcon).build().perform();
        MenuIcon.click();
    }
    public void LeaveBtn_click(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=\"Leave\"]")));
        WebElement leave=driver.findElement(By.xpath("//a[text()=\"Leave\"]"));
        leave.click();
    }
    public void On_Duty_Application(){
        WebElement onDuty=driver.findElement(By.xpath("//a[text()=\"OnDuty Application\"]"));
        onDuty.click();
    }
    public void Proceed_Btn(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnProceed")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement currentDay=driver.findElement(By.id("btnProceed"));
        currentDay.click();
    }
    public void SelectReason(){
        //option[text()="On Duty"]
        Select reason_dropdown= new Select(driver.findElement(By.id("OnDutyHD_laReasonDrop")));
        reason_dropdown.selectByVisibleText("On Duty");
        //Enter the mobile number
        WebElement contactNumber=driver.findElement(By.id("OnDutyHD_laPhoneNo"));
        contactNumber.click();
        contactNumber.sendKeys("<MobileNumber>");
    }
    public void ApplyBtn_click(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSubmit")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement applyBtn=driver.findElement(By.id("btnSubmit"));
        applyBtn.click();

    }
    public void AlertHandle(){
        //Popup Alert screen handle
        //Switching to Alert
        Alert alert=driver.switchTo().alert();
        //capture alert message
        String alertMsg=driver.switchTo().alert().getText();
        //display the Alert Message
        System.out.println("Alert Message is:"+alertMsg);
        //Accept the Alert
        alert.accept();
    }
    public void BackBtn_click(){
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        WebElement backBtn=driver.findElement(By.xpath("//input[@value=\"Back\"]"));
        backBtn.click();

    }
    public void HomeBtn_click(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=\"Home\"]")));
        WebElement HomeIcon=driver.findElement(By.xpath("//a[text()=\"Home\"]"));
        Actions mouseHover= new Actions(driver);
        mouseHover.moveToElement(HomeIcon).build().perform();
        HomeIcon.click();
    }
    public void DatePicker(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement datePicker=driver.findElement(By.xpath("//input[@id=\"OnDutyHD_laLeaveFrom\"]"));
        datePicker.click();
    }
    public void previousMonth(){
        //click previous Month on date Table
        WebElement previous_month=driver.findElement(By.xpath("//div[@class=\"datepicker-days\"]//th[@class=\"prev\"]"));
        previous_month.click();
    }
    public void Apply_OD_LastMonth(){
        InvokeBrowser();
        UserName_Entry();
        PassWord_Entry();
        SignIn_btn_click();
        MenuBtn_click();
        LeaveBtn_click();
        On_Duty_Application();
        DatePicker();
        previousMonth();
        //Enter the row Here i take row is i
        int i=1;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        for (int j=2;j<=5;j++){
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            WebElement row_val=driver.findElement(By.xpath("//div[@class=\"datepicker datepicker-dropdown dropdown-menu datepicker-orient-left datepicker-orient-top\"]/div[@class=\"datepicker-days\"]/table/tbody/tr["+i+"]/td["+j+"]"));
            row_val.click();
            Proceed_Btn();
            SelectReason();
            ApplyBtn_click();
            AlertHandle();
            BackBtn_click();
            On_Duty_Application();
            DatePicker();
            previousMonth();
        }

    }
    public void Apply_OD_CurMonth_Of_Week1(){
        InvokeBrowser();
        UserName_Entry();
        PassWord_Entry();
        SignIn_btn_click();
        MenuBtn_click();
        LeaveBtn_click();
        On_Duty_Application();
        DatePicker();
        //Enter the row Here i take row is i
        int i=1;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        for (int j=2;j<=6;j++){
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            WebElement row_val=driver.findElement(By.xpath("//div[@class=\"datepicker datepicker-dropdown dropdown-menu datepicker-orient-left datepicker-orient-top\"]/div[@class=\"datepicker-days\"]/table/tbody/tr["+i+"]/td["+j+"]"));
            row_val.click();
            Proceed_Btn();
            SelectReason();
            ApplyBtn_click();
            AlertHandle();
            BackBtn_click();
            On_Duty_Application();
            DatePicker();

        }

    }
    public void Apply_OD_CurMonth_Of_Week2(){
        InvokeBrowser();
        UserName_Entry();
        PassWord_Entry();
        SignIn_btn_click();
        MenuBtn_click();
        LeaveBtn_click();
        On_Duty_Application();
        DatePicker();
        //Enter the row Here i take row is i
        int i=2;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        for (int j=2;j<=6;j++){
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            WebElement row_val=driver.findElement(By.xpath("//div[@class=\"datepicker datepicker-dropdown dropdown-menu datepicker-orient-left datepicker-orient-top\"]/div[@class=\"datepicker-days\"]/table/tbody/tr["+i+"]/td["+j+"]"));
            row_val.click();
            Proceed_Btn();
            SelectReason();
            ApplyBtn_click();
            AlertHandle();
            BackBtn_click();
            On_Duty_Application();
            DatePicker();

        }

    }
    public void Apply_OD_CurMonth_Of_Week3(){
        InvokeBrowser();
        UserName_Entry();
        PassWord_Entry();
        SignIn_btn_click();
        MenuBtn_click();
        LeaveBtn_click();
        On_Duty_Application();
        DatePicker();
        //Enter the row Here i take row is i
        int i=3;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        for (int j=2;j<=6;j++){
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            WebElement row_val=driver.findElement(By.xpath("//div[@class=\"datepicker datepicker-dropdown dropdown-menu datepicker-orient-left datepicker-orient-top\"]/div[@class=\"datepicker-days\"]/table/tbody/tr["+i+"]/td["+j+"]"));
            row_val.click();
            Proceed_Btn();
            SelectReason();
            ApplyBtn_click();
            AlertHandle();
            BackBtn_click();
            On_Duty_Application();
            DatePicker();

        }

    }
    public void Apply_OD_CurMonth_Of_Week4(){
        InvokeBrowser();
        UserName_Entry();
        PassWord_Entry();
        SignIn_btn_click();
        MenuBtn_click();
        LeaveBtn_click();
        On_Duty_Application();
        DatePicker();
        //Enter the row Here i take row is i
        int i=4;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        for (int j=2;j<=6;j++){
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            WebElement row_val=driver.findElement(By.xpath("//div[@class=\"datepicker datepicker-dropdown dropdown-menu datepicker-orient-left datepicker-orient-top\"]/div[@class=\"datepicker-days\"]/table/tbody/tr["+i+"]/td["+j+"]"));
            row_val.click();
            Proceed_Btn();
            SelectReason();
            ApplyBtn_click();
            AlertHandle();
            BackBtn_click();
            On_Duty_Application();
            DatePicker();

        }

    }
    public void Apply_OD_CurMonth_Of_Week5(){
        InvokeBrowser();
        UserName_Entry();
        PassWord_Entry();
        SignIn_btn_click();
        MenuBtn_click();
        LeaveBtn_click();
        On_Duty_Application();
        DatePicker();
        //Enter the row Here i take row is i
        int i=5;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        for (int j=2;j<=6;j++){
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            WebElement row_val=driver.findElement(By.xpath("//div[@class=\"datepicker datepicker-dropdown dropdown-menu datepicker-orient-left datepicker-orient-top\"]/div[@class=\"datepicker-days\"]/table/tbody/tr["+i+"]/td["+j+"]"));
            row_val.click();
            Proceed_Btn();
            SelectReason();
            ApplyBtn_click();
            AlertHandle();
            BackBtn_click();
            On_Duty_Application();
            DatePicker();

        }

    }
    public void logout_btn_click(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li[@class=\"imgtop yellow1\"]")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement SquareIcon=driver.findElement(By.xpath("//ul/li[@class=\"imgtop yellow1\"]"));
        Actions mouseHover= new Actions(driver);
        mouseHover.moveToElement(SquareIcon).build().perform();
        //click logout button
        WebElement LogOutBtn=driver.findElement(By.xpath("//button[text()=\"Sign out\"]"));
        LogOutBtn.click();

    }
    public void closeBrowser(){
        driver.quit();
    }
    public void Login_WeCare_Portal(){
        WeCare_Portal login_page = new WeCare_Portal();
        login_page.InvokeBrowser();
        login_page.UserName_Entry();
        login_page.PassWord_Entry();
        login_page.SignIn_btn_click();
        login_page.logout_btn_click();
        login_page.closeBrowser();

    }
    public void Apply_OD_CurrentDate(){
        WeCare_Portal portal = new WeCare_Portal();
        portal.InvokeBrowser();
        portal.UserName_Entry();
        portal.PassWord_Entry();
        portal.SignIn_btn_click();
        portal.MenuBtn_click();
        portal.LeaveBtn_click();
        portal.On_Duty_Application();
        portal.Proceed_Btn();
        portal.SelectReason();
        portal.ApplyBtn_click();
        portal.AlertHandle();
        portal.BackBtn_click();
        portal.MenuBtn_click();
        portal.HomeBtn_click();
        portal.logout_btn_click();
        portal.closeBrowser();
    }


}
