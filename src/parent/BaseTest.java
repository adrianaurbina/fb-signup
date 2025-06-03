package tests.parent;

import utils.DataGenerator;
import org.testng.annotations.*;
import pages.FbRegisterUserPage;
import utils.EnumWebDriver;
import drivers.WebDriverFactory;

import java.text.SimpleDateFormat;

public abstract class BaseTest {
    protected FbRegisterUserPage signupPage;
    protected WebDriverFactory driver;

    @BeforeMethod
    protected void setupTest() {
        driver = new WebDriverFactory();
        driver.initDriver(EnumWebDriver.CHROME);
        this.signupPage = new FbRegisterUserPage(driver);
    }

    @AfterMethod
    protected void teardownTest() {
        takeScreenshot();
        this.driver.quitDriver();
    }

    protected void takeScreenshot() {
        String timestamp = DataGenerator.returnCurrentTimestamp( new SimpleDateFormat("yyyyMMdd_HHmmss"));
        String screenshotLocation = "C://AutomationScreenshots//Addie_" + timestamp + ".png";
        this.driver.takeScreenshot(screenshotLocation);
    }
}
