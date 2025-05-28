import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.addielearn.FacebookLogin.enums.EnumWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {
	private WebDriver driver;

	public void initDriver (EnumWebDriver type) {
		if (this.driver == null) {
			switch (type) {
				case CHROME:
					WebDriverManager.chromedriver().setup();
					this.driver = new ChromeDriver();
				break;

				case EDGE:
					WebDriverManager.edgedriver().setup();
					this.driver = new EdgeDriver();
				break;

				case FIREFOX:
					WebDriverManager.firefoxdriver().setup();
					this.driver = new FirefoxDriver();
				break;

				default:
					throw new RuntimeException("Invalid driver type");
		}
			//Wait
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 driver.manage().window().maximize();
		}
	}

	public void goTo(String typeURL) {
		 driver.get(typeURL);
	}


	public void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	public WebDriver getDriver() {
		return this.driver;
		}

	protected WebDriverWait getExplicitWait() {
		return new WebDriverWait(driver, Duration.ofSeconds(15));
	}
}


