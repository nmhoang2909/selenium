package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {

    private WebDriver driver;

    private static final String MAC = "mac";
    private static final String WIN = "win";

    private static final String GECKO_PROPERTY = "webdriver.gecko.driver";
    private static final String CHROME_PROPERTY = "webdriver.chrome.driver";

    private static final String GECKO_MAC_PATH_FILE = "src/main/java/driverStore/geckodriver_mac";
    private static final String CHROME_MAC_PATH_FILE = "src/main/java/driverStore/chromedriver_mac";

    private static final String GECKO_WIN_PATH_FILE = "src/main/java/driverStore/geckodriver_win.exe";
    private static final String CHROME_WIN_PATH_FILE = "src/main/java/driverStore/chromedriver_win.exe";


    public enum Browsers {
        FIREFOX, CHROME
    }

    // Create new WebDriver
    private WebDriver createDriver(Browsers browser) {
        if (browser.equals(Browsers.FIREFOX)) {
            if (System.getProperty("os.name").toLowerCase().contains(MAC)) {
                System.setProperty(GECKO_PROPERTY, GECKO_MAC_PATH_FILE);
            } else if (System.getProperty("os.name").toLowerCase().contains(WIN)) {
                System.setProperty(GECKO_PROPERTY, GECKO_WIN_PATH_FILE);
            }
            return this.driver = new FirefoxDriver();
        } else if (browser.equals(Browsers.CHROME)) {
            if (System.getProperty("os.name").toLowerCase().contains(MAC)) {
                System.setProperty(CHROME_PROPERTY, CHROME_MAC_PATH_FILE);
            } else if (System.getProperty("os.name").toLowerCase().contains(WIN)) {
                System.setProperty(CHROME_PROPERTY, CHROME_WIN_PATH_FILE);
            }
            return this.driver = new ChromeDriver();
        } else
            return this.driver = null;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    private void initDriver(Browsers browser) {
        if (this.driver == null) {
            createDriver(browser);
        }
    }

    public DriverFactory(Browsers browser) {
        initDriver(browser);
    }
}
