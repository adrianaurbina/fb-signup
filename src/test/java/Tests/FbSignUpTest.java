package Tests;
import java.util.Calendar;
import Drivers.WebDriverFactory;
import Models.PersonModel;
import Pages.FbRegisterUser;
import Utils.EnumWebDriver;
import org.testng.annotations.*;

public class FbSignUpTest {
	private FbRegisterUser signupPage;
	private WebDriverFactory driver;

	@BeforeMethod
	public void setupTest() {
		driver = new WebDriverFactory();
		driver.initDriver(EnumWebDriver.CHROME);
		
		signupPage = new FbRegisterUser(driver);
		
	}
	
	@Test
	public void HelloWorld() {
		System.out.println("hello culeros");
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

		signupPage
			.fillForm(user)
			.dummy();

	}

	@AfterMethod
	public void teardownTest() {
		//signupPage.quit();
		this.driver.quitDriver();
	}
}
