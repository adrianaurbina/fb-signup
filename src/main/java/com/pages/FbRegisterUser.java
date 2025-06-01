package test.java.Pages;

import java.text.SimpleDateFormat;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.Drivers.WebDriverFactory;
import test.java.Models.PersonModel;
import Utils.EnumGender;

public class FbRegisterUser extends BasePage {
	public FbRegisterUser(WebDriverFactory driver) {
		super(driver);
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

	public FbRegisterUser fillForm(PersonModel user) {
		this.driver.goTo("https://facebook.com");

		buttonCreateNewAccount.click();

		// Way 1 with explicit wait
		WebDriverWait wait = new WebDriverWait(this.driver.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys(user.firstname);

		// Way 2 with implicit wait
		//firstName.sendKeys(user.firstname);

		lastName.sendKeys(user.lastname);
		PhoneOrEmail.sendKeys(user.mailorphone);
		NewPassword.sendKeys(user.password);

		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		String day = sdf.format(user.birthdate);
		new Select(Day).selectByVisibleText(day); //ToDo Addie find how to print DAY without leading zeros (needed '3' and is searching for '03')

		sdf = new SimpleDateFormat("MMM");
		String month = sdf.format(user.birthdate);
		new Select(Month).selectByVisibleText(month);  //ToDo Addie find how to print MONTH without leading zeros

		sdf = new SimpleDateFormat("yyyy");
		String year = sdf.format(user.birthdate);
		new Select(Year).selectByVisibleText(year);

		selectGender(user.gender);
		return this;
	}

	private void selectGender(EnumGender CGender) {
		switch (CGender) {
		case Female:
			genderFemale.click();
			break;
		case Male:
			genderMale.click();
			break;
		case Custom:
			genderCustom.click();
			break;
		}
	}
	
	public FbRegisterUser dummy() {
		//Do nothing
		System.out.println("hola culeros");
		return this;
	}

	public FbRegisterUser clickSignUp() {
		SubmitCTA.click();
		return this;
	}
}
