package testCases;

import baseClass.BaseTest;
import helper.Generator;
import org.testng.annotations.Test;

public class GenerateTest extends BaseTest {

    @Test
    public void genEmail() {
        System.out.println(Generator.generateEmail());
    }

    @Test
    public void genUser() {
        System.out.println(Generator.generateUsername());
    }

    @Test
    public void genPass() {
        System.out.println(Generator.generatePassword());
    }

    @Test
    public void genPhone() {
        System.out.println(Generator.generateNumber());
        compareResult("actual", "expected");
    }
}
