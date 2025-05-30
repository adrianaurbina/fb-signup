package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import Drivers.WebDriverFactory;
import Utils.EnumWebDriver;

public class BasePage {
	protected WebDriverFactory driver;
	protected WebDriverWait wait;
	protected String URL;

	protected BasePage(WebDriverFactory driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver.getDriver(), this);
	}

	public void close() {
		this.driver.quitDriver();
	}
}
