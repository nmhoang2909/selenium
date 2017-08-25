package report;

import com.relevantcodes.extentreports.ExtentReports;

/**
 * Created by tuyennguyen on 8/7/17.
 */
public class ExtentManager {
    protected static ExtentReports extent;
    private final static String FILE_PATH = "src/test/java/extentReport/index.html";

    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            extent = new ExtentReports(FILE_PATH, true);
        }
        return extent;
    }
}
