package test.java.Drivers;

import java.time.Duration;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.EnumWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {
	private WebDriver _driver;

	public void initDriver(EnumWebDriver type) {
		if (_driver == null) {
			switch (type) {
			case CHROME:
				WebDriverManager.chromedriver().setup();
				_driver = new ChromeDriver();
				break;
			case EDGE:
				WebDriverManager.edgedriver().setup();
				_driver = new EdgeDriver();
				break;
			case FIREFOX:
				WebDriverManager.firefoxdriver().setup();
				_driver = new FirefoxDriver();
				break;
			default:
				throw new RuntimeException("Invalid driver type");
			}
			// Wait
			_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			_driver.manage().window().setPosition(new Point(-1000, 0)); //open in 2nd screen (when 2nd is on left position)
			_driver.manage().window().maximize();
		}
	}

	public void goTo(String typeURL) {
		_driver.get(typeURL);
	}

	public void quitDriver() {
		if (_driver != null) {
			_driver.quit();
			_driver = null;
		}
	}

	public WebDriver getDriver() {
		return _driver;
	}
}
