import com.addielearn.FacebookLogin.enums.EnumWebDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseTest {

    protected WebDriverFactory Browser;
    protected FbRegisterUser FbRegisterUser;

    @Before
    public void setupTest() {
        this.Browser = new WebDriverFactory();
        this.Browser.initDriver(EnumWebDriver.CHROME);


        FbRegisterUser = new FbRegisterUser(this.Browser);



        //wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit Wait
        //goTo("https://www.facebook.com/signup");

    }

    @After
    public void teardownTest() {
        quitDriver();
    }
}
