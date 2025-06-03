package testCases;

import org.testng.annotations.*;
import models.PersonModel;
import testCases.parent.BaseTest;

public class FbSignUpTest extends BaseTest {

    @Test
    public void testFBSignUpForm() {
        signupPage
            .fillForm(PersonModel.returnDefaultPersonObj())
            .dummy();
    }
}
