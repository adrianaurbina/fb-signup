package test.java.com.tests.testCases;

import org.testng.annotations.*;
import main.java.com.models.PersonModel;
import test.java.com.tests.parent.BaseTest;

public class FbSignUpTest extends BaseTest {

    @Test
    public void testFBSignUpForm() {
        signupPage
            .fillForm(PersonModel.returnDefaultPersonObj())
            .dummy();
    }
}
