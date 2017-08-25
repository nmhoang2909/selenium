package helper;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tuyennguyen on 8/1/17.
 */

public class TakeScreenShot {

    private static final String DATE_FORMAT = "yyyy_MM_dd_HH_mm_ss";
    private static final String PATH_SCREENSHOT_OF_REPORT = "src/test/java/extentReport/";
    private static final String PATH_SCREENSHOT_OF_PROJECT = "src/test/java/screenshot/";

    // Generate path file PNG
    // Return: path to file (string)
    private static String generatePathFilePNG() {
        String timeStamp = new SimpleDateFormat(DATE_FORMAT).format(new Date());
        String sPath = PATH_SCREENSHOT_OF_PROJECT;
        sPath = sPath + timeStamp + ".png";
        return sPath;
    }

    public static void takeScreenShot(WebDriver driver) {
        File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile,new File(generatePathFilePNG()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void takeFullPageScreenShot(WebDriver driver) {
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
        try {
            ImageIO.write(screenshot.getImage(), "PNG", new File(TakeScreenShot.generatePathFilePNG()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String takeScreenShotWithExtentReport(WebDriver driver) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String dest = "screenshot/";
        try {
            dest = dest + new SimpleDateFormat(DATE_FORMAT).format(new Date()) +".png";
            FileUtils.copyFile(screenshotFile, new File(PATH_SCREENSHOT_OF_REPORT + dest));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dest;
    }
}
