package Tests;
import java.time.Duration;
import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Common.EnumWebDriver;

public class FbSignUpTest extends FbRegisterUser {
	
	@Before
	public void setupTest() {
		initDriver(EnumWebDriver.CHROME); 
		wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit Wait
		goTo("https://www.facebook.com/signup");
		PageFactory.initElements(driver, this);
	}
	
	@Test
	public void TestFBSignUpForm() {
		PersonModel user = new PersonModel();
		user.firstname = "Adriana";
		user.lastname = "Urbina";
		user.mailorphone = "adriana.urbina@unosquare.com";
		user.password = "Bank1234#";
		Calendar cal = Calendar.getInstance();
		cal.set(1995, Calendar.AUGUST, 03);
		user.birthdate = cal.getTime();
		
		FillForm(user);
		
	}
    @After
    public void teardownTest() {
    	quitDriver();
    }
}
