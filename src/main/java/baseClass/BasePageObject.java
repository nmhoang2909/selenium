package baseClass;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePageObject {

    protected WebDriver driver;

    // Wait time (seconds)
    private static final int WAIT_TIME = 20;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
    }

    // Wait element to be visibility
    // Input: element to be waited
    protected void waitElementVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Wait element to be clickable
    protected void waitElementClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Set implicit wait
    // Input: Number of seconds to be waited
    protected void implicitWaitElement(long seconds){
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    // Get text of element
    // Return: string of text
    protected String getTextOfElement(WebElement element) {
        waitElementVisibility(element);
        return element.getText();
    }

    // Click on element
    protected void clickOnElement(WebElement element) {
        waitElementClickable(element);
        element.click();
    }

    // Clear text inside element
    protected void clearTextOfElement(WebElement element) {
        waitElementVisibility(element);
        element.clear();
    }

    // Set value for element
    // Input: value - string to be set
    protected void setValueForElement(WebElement element, String value) {
        clearTextOfElement(element);
        element.sendKeys(value);
    }

    // Select dropdown by text
    // Input: text - string of selected text
    protected void selectDropdownByText(WebElement dropdown, String text) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }

    // Select dropdown by index
    // Input: index - index of selected text (int)
    protected void selectDropdownByIndex(WebElement dropdown, int index) {
        Select select = new Select(dropdown);
        select.selectByIndex(index);
    }

    // Wait Alert to be presented
    protected void waitAlertPresent() {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    // Accept Alert
    protected void acceptAlert() {
        waitAlertPresent();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    // Dismiss Alert
    protected void dismissAlert() {
        waitAlertPresent();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    // Set value to Alert
    protected void setValueToAlert(String value) {
        waitAlertPresent();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(value);
        alert.accept();
    }

    // Scroll to see Element on web
    protected void scrollToSeeElement(WebElement element) {
        waitElementVisibility(element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Drag Element and Drop it
    protected void dragAndDropElement(WebElement begin, WebElement end) {
        Actions builder = new Actions(driver);
        Action dragAndDrop = builder.clickAndHold(begin).moveToElement(end).release(end).build();
        dragAndDrop.perform();
    }

    // Mouse over click on hamburger button
    protected void mouseOverClick(WebElement firstElement, WebElement secondElement) {
        Actions action = new Actions(driver);
        waitElementVisibility(firstElement);
        action.moveToElement(firstElement).build().perform();
        waitElementVisibility(secondElement);
        secondElement.click();
    }

}
