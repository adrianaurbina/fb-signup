package test.java.com.tests.parent;

import main.java.com.models.PersonModel;
import main.java.com.utils.DataGenerator;
import org.testng.annotations.*;
import main.java.com.pages.FbRegisterUserPage;
import main.java.com.utils.EnumWebDriver;
import main.java.com.drivers.WebDriverFactory;

import java.text.SimpleDateFormat;

public abstract class BaseTest {
    protected FbRegisterUserPage signupPage;
    protected WebDriverFactory driver;

    //Run before EACH test (can run multiple times)
    @BeforeMethod
    protected void setupTest() {
        System.out.println("setupTest");
        driver = new WebDriverFactory();
        driver.initDriver(EnumWebDriver.CHROME);
        this.signupPage = new FbRegisterUserPage(driver);
    }

    //Run after EACH test (can run multiple times)
    @AfterMethod
    protected void teardownTest() {
        System.out.println("teardownTest");
        takeScreenshot();
        this.driver.quitDriver();
    }

    //Run before entire run (only once per execution)
    @BeforeSuite
    protected void setupSuite() {
        System.out.println("setupSuite");
    }

    //Run after EACH test (can run multiple times)
    @AfterSuite
    protected void teardownSuite() {
        System.out.println("teardownSuite");
        System.out.println("How many persons were created: " + PersonModel.objectCounter);
    }

    protected void takeScreenshot() {
        String timestamp = DataGenerator.returnCurrentTimestamp( new SimpleDateFormat("yyyyMMdd_HHmmss"));
        String screenshotLocation = "C://AutomationScreenshots//Addie_" + timestamp + ".png";
        this.driver.takeScreenshot(screenshotLocation);
    }
}
