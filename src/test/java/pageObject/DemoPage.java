package pageObject;

import baseClass.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DemoPage extends BasePageObject {

    public DemoPage(WebDriver driver) {
        super(driver);
    }

    /**
     * List of Elements
     */

    @FindBy(how = How.XPATH, xpath = ".//*[@id='tabs-1']/b")
    public static WebElement tab1;


    /**
     * List of Functions
     */

    public String getTitleTab1() {
        return getTextOfElement(tab1);
    }

    public void navigateToDemoPage() {
        driver.get("http://demoqa.com");
    }

    public void backToHomePage() {
        driver.navigate().back();
    }

    public void acceptAlertDemo() {
        acceptAlert();
    }

    public void dismissAlertDemo() {
        dismissAlert();
    }

    public void enterDataToAlertDemo() {
        setValueToAlert("abcdef");
    }

    public void dragElementDemo() {
        WebElement From = driver.findElement(By.xpath(".//*[@id='treebox1']/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[4]/span"));
        System.out.println(From.getText());
        WebElement To = driver.findElement(By.xpath(".//*[@id='treebox2']/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[4]/span"));
        System.out.println(To.getText());

        WebElement elementPresent = driver.findElement(By.xpath("html/body/div[1]/div/div[2]/h2"));
        scrollToSeeElement(elementPresent);

        dragAndDropElement(From, To);
    }

    public void mouseOverClickDemo() {
        WebElement element = driver.findElement(By.linkText("Product Category"));
        WebElement secondElement = driver.findElement(By.linkText("iPhones"));
        mouseOverClick(element, secondElement);
    }

}
