package test.java.com.tests;

import org.testng.annotations.*;
import java.util.Calendar;
import main.java.com.models.PersonModel;
import main.java.com.pages.FbRegisterUser;
import main.java.com.utils.EnumWebDriver;
import main.java.com.drivers.WebDriverFactory;

public class FbSignUpTest {
    private FbRegisterUser signupPage;
    private WebDriverFactory driver;

    @BeforeMethod
    public void setupTest() {
        driver = new WebDriverFactory();
        driver.initDriver(EnumWebDriver.CHROME);
        this.signupPage = new FbRegisterUser(driver);
    }

    @Test
    public void testFBSignUpForm() {
        PersonModel user = new PersonModel();
        user.firstname = "Adriana";
        user.lastname = "Urbina";
        user.mailorphone = "adriana.urbina@unosquare.com";
        user.password = "Bank1234#";
        Calendar cal = Calendar.getInstance();
        cal.set(1995, Calendar.AUGUST, 03);
        user.birthdate = cal.getTime();

        signupPage
                .fillForm(user)
                .dummy();
    }

    @AfterMethod
    public void teardownTest() {
        this.driver.quitDriver();
    }
}
