package Drivers;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Common.EnumWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {
	public static WebDriver driver;

	public static WebDriver initDriver (EnumWebDriver type) {
if (driver == null) {
	switch (type) {
	case CHROME:
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	break;
	case EDGE:
	WebDriverManager.edgedriver().setup();
	driver = new EdgeDriver();
	break;
	case FIREFOX:
	WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver();
	break;
	default:
		throw new RuntimeException("Invalid driver type");
}
		//Wait
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	 driver.manage().window().maximize();

}
		return driver;
}

	public void goTo(String typeURL) {
		driver.get(typeURL);
}


	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
	public static WebDriver getDriver() {
		return driver;
	}

	public static WebDriverWait getExplicitWait() {
		return new WebDriverWait(driver, Duration.ofSeconds(15));
}
}


