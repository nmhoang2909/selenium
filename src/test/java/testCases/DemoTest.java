package testCases;

import baseClass.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import pageObject.DemoPage;


public class DemoTest extends BaseTest {


    //////// Test cases start here ////////
    @Test(description = "Compare 5 equal 5")
    public void test_1() {
        DemoPage demoPage = PageFactory.initElements(driver,DemoPage.class);
        demoPage.navigateToDemoPage();
        compareResult(5, 4);
        driver.navigate().to("https://www.google.com.vn/?gfe_rd=cr&ei=A8t5WZSjDoel8wfXtpvgDQ&gws_rd=ssl");
        demoPage.backToHomePage();

    }

    @Test(description = "Compare 5 equal 6")
    public void test_2() {
        DemoPage demoPage = PageFactory.initElements(driver,DemoPage.class);
        demoPage.navigateToDemoPage();
        compareResult(5, 5);
    }


}
