package testCases;

import baseClass.BaseTest;
import helper.TakeScreenShot;
import org.testng.annotations.Test;


public class ScreenShotTest extends BaseTest {


    @Test
    public void takePicHomePage() {
        driver.navigate().to("https://www.guru99.com/");
        TakeScreenShot.takeFullPageScreenShot(driver);
    }

}
