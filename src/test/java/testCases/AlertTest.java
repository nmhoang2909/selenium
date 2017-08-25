package testCases;

import baseClass.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObject.DemoPage;


public class AlertTest extends BaseTest {


    @Test()
    public void test_3() throws InterruptedException {
        driver.get("http://toolsqa.wpengine.com/handling-alerts-using-selenium-webdriver/");
        driver.findElement(By.xpath("//*[@id='content']/p[4]/button")).click();

        Thread.sleep(3000);

        PageFactory.initElements(driver, DemoPage.class).acceptAlertDemo();
        Thread.sleep(3000);
    }

    @Test()
    public void test_4() throws InterruptedException {
        driver.get("http://toolsqa.wpengine.com/handling-alerts-using-selenium-webdriver/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id='content']/p[11]/button")).click();

        Thread.sleep(3000);

        PageFactory.initElements(driver, DemoPage.class).dismissAlertDemo();
        Thread.sleep(3000);
    }

    @Test()
    public void test_5() throws InterruptedException {
        driver.get("http://toolsqa.wpengine.com/handling-alerts-using-selenium-webdriver/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath(".//*[@id='content']/p[11]/button")).click();
        Thread.sleep(3000);

        PageFactory.initElements(driver, DemoPage.class).enterDataToAlertDemo();
        Thread.sleep(3000);
    }

    @Test()
    public void test_6() throws InterruptedException {
        driver.get("http://www.dhtmlx.com/docs/products/dhtmlxTree/index.shtml");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        PageFactory.initElements(driver, DemoPage.class).dragElementDemo();
        Thread.sleep(3000);
    }

    @Test()
    public void test_7() throws InterruptedException {
        driver.get("http://store.demoqa.com/");

        PageFactory.initElements(driver, DemoPage.class).mouseOverClickDemo();
        Thread.sleep(3000);
    }


}
