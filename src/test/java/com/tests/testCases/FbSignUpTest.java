package test.java.com.tests.testCases;

import org.testng.annotations.*;
import java.util.Calendar;
import main.java.com.models.PersonModel;
import test.java.com.tests.parent.BaseTest;

public class FbSignUpTest extends BaseTest {

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
}
