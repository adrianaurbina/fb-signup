package main.java.com.pages;

import java.text.SimpleDateFormat;
import java.time.Duration;
import main.java.com.parent.BasePage;
import main.java.com.parent.IBasePage;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import main.java.com.drivers.WebDriverFactory;
import main.java.com.models.PersonModel;
import main.java.com.utils.EnumGender;

public class FbRegisterUserPage extends BasePage implements IBasePage {
	public FbRegisterUserPage(WebDriverFactory driver) {
		super(driver); // super keyword makes reference to the parent
	}

	@FindBy(css = "[data-testid='open-registration-form-button']")
	private WebElement buttonCreateNewAccount;

	@FindBy(name = "firstname")
	private WebElement firstName;

	@FindBy(name = "lastname")
	private WebElement lastName;

	@FindBy(id = "day")
	private WebElement Day;

	@FindBy(id = "month")
	private WebElement Month;

	@FindBy(id = "year")
	private WebElement Year;

	@FindBy(xpath = "//input[@value='1']")
	private WebElement genderFemale;

	@FindBy(xpath = "//input[@value='2']")
	private WebElement genderMale;

	@FindBy(xpath = "//input[@value='-1']")
	private WebElement genderCustom;

	@FindBy(id = "preferred_pronoun")
	private WebElement PreferredPronoun;

	@FindBy(id = "custom_gender")
	private WebElement CustomGender;

	@FindBy(name = "reg_email__")
	private WebElement PhoneOrEmail;

	@FindBy(id = "password_step_input")
	private WebElement NewPassword;

	@FindBy(name = "websubmit")
	private WebElement SubmitCTA;

	public void goTo(String url) {
		this.driver.goTo("https://facebook.com");
	}

	public FbRegisterUserPage fillForm(PersonModel user) throws InterruptedException { // throws 'AVISA' que puede lanzar una exception de ese tipo
		goTo("https://facebook.com");

		buttonCreateNewAccount.click();

		// Way 1 with explicit wait
		WebDriverWait wait = new WebDriverWait(this.driver.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys(user.firstname);

		// Way 2 with implicit wait
		//firstName.sendKeys(user.firstname);

		Thread.sleep(1500);

		lastName.sendKeys(user.lastname);
		PhoneOrEmail.sendKeys(user.mailorphone);
		NewPassword.sendKeys(user.password);

		SimpleDateFormat sdf = new SimpleDateFormat("d");
		String day = sdf.format(user.birthdate);
		new Select(Day).selectByVisibleText(day);

		sdf = new SimpleDateFormat("MMM");
		String month = sdf.format(user.birthdate);
		new Select(Month).selectByVisibleText(month);

		sdf = new SimpleDateFormat("yyyy");
		String year = sdf.format(user.birthdate);
		new Select(Year).selectByVisibleText(year);

		selectGender(user.gender);
		return this;
	}

	private void selectGender(EnumGender CGender) {
		switch (CGender) {
		case Female:
			this.click(genderFemale, "Female [Radio Button]");
			break;
		case Male:
			genderMale.click();
			break;
		case Custom:
			genderCustom.click();
			break;
		}
	}
	
	public FbRegisterUserPage dummy() {
		//Do nothing
		System.out.println("dummy");
		return this;
	}

	public FbRegisterUserPage clickSignUp() {
		SubmitCTA.click();
		return this;
	}

	public void logOut() {
		throw new NotImplementedException("Nos falta implementar aqui raza");
	}
}
