package baseClass;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import helper.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import report.ExtentManager;
import report.ExtentTestManager;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import static helper.TakeScreenShot.takeScreenShotWithExtentReport;

public class BaseTest extends ExtentManager {

    protected WebDriver driver;
    private ExtentTest test;
    private DriverFactory.Browsers browserName;

    private static final int IMPLICIT_WAIT_TIME = 20;

    @BeforeSuite
    protected void beforeSuite() {
        getReporter();
    }

    @AfterSuite
    protected void afterSuite() {
        extent.close();
    }

    // Using to run by Jenkins
//    @Parameters("browser")
//    @BeforeMethod
//    protected void beforeMethod(DriverFactory.Browsers browser, Method method) {
//        this.driver = new DriverFactory(browser).getDriver();
//        this.browserName = browser;
//        this.driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
//        try {
//            this.driver.manage().window().maximize();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        startExtReport(method);
//    }

    // Using to write and run testcase locally
    @BeforeMethod
    protected void beforeMethod(Method method) {
        this.driver = new DriverFactory(DriverFactory.Browsers.FIREFOX).getDriver();
        this.browserName = DriverFactory.Browsers.FIREFOX;
        this.driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        try {
            this.driver.manage().window().maximize();
        } catch (Exception e) {
            e.printStackTrace();
        }
        startExtReport(method);
    }

    @AfterMethod
    protected void afterMethod(ITestResult result) {
        generateExtResult(result);
        endExtReport();
        this.driver.manage().deleteAllCookies();
        this.driver.close();
    }


    protected void compareResult(Object actual, Object expected) {
        Assert.assertEquals(actual, expected);
    }

    private void startExtReport(Method method) {
        test = ExtentTestManager.startTest("[" + browserName.toString() + "]"
                + " :: " + this.getClass().getSimpleName()
                + " :: " + method.getName(), method.getName());
        // Test Script Author Name
        test.assignAuthor("QA Team");
        // Test Category Defined Here
        test.assignCategory("Selenium Testing");
    }

    private void endExtReport() {
        extent.endTest(test);
        extent.flush();
    }

    private void generateExtResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(LogStatus.FAIL, result.getThrowable());
            String pathImage = takeScreenShotWithExtentReport(driver);
            test.log(LogStatus.FAIL, "Screenshot below: " + test.addScreenCapture(pathImage));
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
        } else {
            test.log(LogStatus.PASS, "Test passed");
        }
    }
}
