package test.java.com.tests.parent;

import main.java.com.utils.DataGenerator;
import org.testng.annotations.*;
import main.java.com.pages.FbRegisterUserPage;
import main.java.com.utils.EnumWebDriver;
import main.java.com.drivers.WebDriverFactory;

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
