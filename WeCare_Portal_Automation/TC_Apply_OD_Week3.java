package WeCare_Portal_Automation;

public class TC_Apply_OD_Week3 {
    public static void main(String[] args){
        WeCare_Portal test = new WeCare_Portal();
        test.Apply_OD_CurMonth_Of_Week3();
        test.MenuBtn_click();
        test.HomeBtn_click();
        test.logout_btn_click();
        test.closeBrowser();
    }
}
