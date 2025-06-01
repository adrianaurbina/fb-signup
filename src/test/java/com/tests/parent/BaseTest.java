package test.java.com.tests.parent;

import org.testng.annotations.*;
import main.java.com.pages.FbRegisterUser;
import main.java.com.utils.EnumWebDriver;
import main.java.com.drivers.WebDriverFactory;

public abstract class BaseTest {
    protected FbRegisterUser signupPage;
    protected WebDriverFactory driver;

    @BeforeMethod
    protected void setupTest() {
        driver = new WebDriverFactory();
        driver.initDriver(EnumWebDriver.CHROME);
        this.signupPage = new FbRegisterUser(driver);
    }

    @AfterMethod
    protected void teardownTest() {
        this.driver.quitDriver();
    }
}
