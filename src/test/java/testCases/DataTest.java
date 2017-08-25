package testCases;

import baseClass.BaseTest;
import helper.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataTest extends BaseTest {


    @Test(description = "test read data from excel")
    public void test_8() throws Exception {
        ExcelUtils.getTableData(ExcelUtils.FILE_TEST_DATA,"Sheet1");
        String sUserName = ExcelUtils.getCellData(1, 1);
        String sPassword = ExcelUtils.getCellData(1, 2);
        System.out.println(sUserName);
        System.out.println(sPassword);
    }

    @DataProvider(name = "login with data list")
    public static Object[][] login() throws Exception {
        Object[][] testObjArray = ExcelUtils.getTableData(ExcelUtils.FILE_TEST_DATA,"Sheet1");
        return (testObjArray);
    }

    @Test(description = "test data provider from excel", dataProvider = "login with data list")
    public void test_9(String sUserName,String sPassword) throws Exception {
        System.out.print(sUserName);
        System.out.println(sPassword);
    }


}
