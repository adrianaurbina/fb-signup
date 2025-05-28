import java.text.SimpleDateFormat;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import com.addielearn.FacebookLogin.enums.EnumGender;

public class FbRegisterUser {

	private WebDriverFactory driver;

	public FbRegisterUser(WebDriverFactory driver) {
		this.driver = driver;

		PageFactory.initElements(this.driver.getDriver(), this);
	}

@FindBy(name="firstname")
private WebElement firstName;

@FindBy(name="lastname")
private WebElement lastName;

@FindBy(id="day")
private WebElement Day;

@FindBy(id="month")
private WebElement Month;

@FindBy(id="year")
private WebElement Year;

@FindBy(xpath = "//input[@value='1']")
private WebElement genderFemale;

@FindBy(xpath = "//input[@value='2']")
private WebElement genderMale;

@FindBy(xpath = "//input[@value='-1']")
private WebElement genderCustom;

@FindBy(id="preferred_pronoun")
private WebElement PreferredPronoun;

@FindBy(id="custom_gender")
private WebElement CustomGender;

@FindBy(id="u_0_h_mu")
private WebElement PhoneOrEmail;

@FindBy(id="password_step_input")
private WebElement NewPassword;

@FindBy(id="u_0_n_2N")
private WebElement SubmitCTA;

protected void FillForm (PersonModel user) {

	//goto here (if possible declare in parent interface)

	wait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys(user.firstname);
	lastName.sendKeys(user.lastname);
	PhoneOrEmail.sendKeys(user.mailorphone);
	NewPassword.sendKeys(user.password);
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd");
	String day = sdf.format(user.birthdate);
	new Select(Day).selectByVisibleText(day);
	
	sdf = new SimpleDateFormat("MMM");
	String month = sdf.format(user.birthdate);
    new Select(Month).selectByVisibleText(month);
    
    sdf = new SimpleDateFormat("yyyy");
	String year = sdf.format(user.birthdate);
    new Select(Year).selectByVisibleText(year);
    
    selectGender(user.gender);
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
public void clickSignUp() {
	SubmitCTA.click();
}
}
