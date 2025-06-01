package main.java.com.drivers;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import main.java.com.utils.EnumWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {
	private WebDriver _driver;

	public void initDriver(EnumWebDriver type) {

		try {
			if (_driver == null) {
				switch (type) {
					case CHROME:
						ChromeOptions chromeOptions;
						chromeOptions = new ChromeOptions();
						chromeOptions.addArguments("--remote-allow-origins=*");
						chromeOptions.addArguments("--disable-extensions");
						chromeOptions.addArguments("--disable-notifications");
						chromeOptions.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.127 Safari/537.36");
						chromeOptions.addArguments("--disable-blink-features=AutomationControlled");

						WebDriverManager.chromedriver().setup();
						_driver = new ChromeDriver(chromeOptions); //aqui esta el pedo
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
				_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				_driver.manage().window().setPosition(new Point(-1000, 0)); //open in 2nd screen (when 2nd is on left position)
				_driver.manage().window().maximize();
			}
		}
		catch (Exception e) {
			System.out.println("Addie: " + e.getMessage());
			throw e;
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

	public void takeScreenshot(String fileLocation) {
		//https://www.guru99.com/take-screenshot-selenium-webdriver.html
		try {
			//Convert web driver object to TakeScreenshot
			TakesScreenshot scrShot =((TakesScreenshot)getDriver());

			//Call getScreenshotAs method to create image file
			File srcFile=scrShot.getScreenshotAs(OutputType.FILE);

			//Move image file to new destination
			File destFile=new File(fileLocation);

			//Copy file at destination
			FileUtils.copyFile(srcFile, destFile);
		}
		catch (Exception e) {
			System.out.println("FAILURE ::: Not able to take screenshot in: " + fileLocation);
		}
	}

	public WebDriver getDriver() {
		return _driver;
	}
}
