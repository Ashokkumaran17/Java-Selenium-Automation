package WeCare_Portal_Automation;

public class Tc_Apply_OD_Week5 {
    public static void main(String[] args){
        WeCare_Portal test = new WeCare_Portal();
        test.Apply_OD_CurMonth_Of_Week5();
        test.MenuBtn_click();
        test.HomeBtn_click();
        test.logout_btn_click();
        test.closeBrowser();
    }
}
