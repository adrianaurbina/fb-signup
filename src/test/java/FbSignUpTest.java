import com.addielearn.FacebookLogin.enums.EnumWebDriver;

import java.time.Duration;
import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FbSignUpTest extends BaseTest {
	

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
