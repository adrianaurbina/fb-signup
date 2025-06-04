package test.java.com.tests.testCases;

import main.java.com.utils.UtilsInterviews;
import org.testng.annotations.Test;

public class InterviewTest {

    @Test(priority = 1)
    public void testInterview() {
        UtilsInterviews.challenge();
    }
}
