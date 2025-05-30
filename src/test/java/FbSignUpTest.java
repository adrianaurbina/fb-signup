import java.util.Calendar;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FbSignUpTest {
	private FbRegisterUser signupPage;

	@Before
	public void setupTest() {
		signupPage = new FbRegisterUser();
		signupPage.GoToBasePage();
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

		signupPage.FillForm(user);

	}

	@After
	public void teardownTest() {
		signupPage.close();
	}
}
