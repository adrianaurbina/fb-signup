package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import Common.EnumWebDriver;
import Drivers.WebDriverFactory;

public class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected String URL;

	protected BasePage(String url) {
		driver = WebDriverFactory.initDriver(EnumWebDriver.CHROME);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		URL = url;

	}

	public void GoToBasePage() {
		driver.get(URL);
		PageFactory.initElements(driver, this);
	}

	public void close() {
		driver.quit();
	}
}
