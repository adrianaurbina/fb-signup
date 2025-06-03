package test.java.com.tests.testCases;

import main.java.com.utils.EnumGender;
import org.testng.annotations.*;
import main.java.com.models.PersonModel;
import test.java.com.tests.parent.BaseTest;

import java.util.Calendar;

public class FbSignUpTest extends BaseTest {

    @Test(priority = 1)
    public void testFBSignUpFormWoman() throws InterruptedException {
        signupPage
            .fillForm(PersonModel.returnDefaultPersonObj(true))
            .dummy();
    }

    @Test(priority = 2)
    public void testFBSignUpFormOnvre() throws InterruptedException {
        signupPage
                .fillForm(PersonModel.returnDefaultPersonObj(false))
                .dummy();
    }

    @Test(priority = 3)
    public void testFBSignUpFormNonBinary() throws InterruptedException {
        Calendar cal = Calendar.getInstance();
        cal.set(1995, Calendar.AUGUST, 03);
        PersonModel user = new PersonModel();
        user.firstname = "Michelle";
        user.lastname = "Urbina";
        user.mailorphone = "dsnhrsh.urbina@unosquare.com";
        user.password = "Bank1234#";
        user.birthdate = cal.getTime();
        user.gender = EnumGender.Custom;

        signupPage
                .fillForm(user)
                .dummy();
    }
}
