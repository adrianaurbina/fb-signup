package main.java.com.parent;

import main.java.com.logger.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import main.java.com.drivers.WebDriverFactory;

public class BasePage {
	protected WebDriverFactory driver;
	protected WebDriverWait wait;
	protected String URL;

	protected BasePage(WebDriverFactory driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver.getDriver(), this);
	}

	protected void click(WebElement element, String description) {
		element.click();
		Log.print("Click on element: " + description);
	}

	public void close() {
		this.driver.quitDriver();
	}
}
