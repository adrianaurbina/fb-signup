package Pages;
import java.text.SimpleDateFormat;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import Common.EnumGender;
import Models.PersonModel;

public class FbRegisterUser extends BasePage{
	public FbRegisterUser() {
		super("https://www.facebook.com/signup");
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

@FindBy(name="reg_email__")
private WebElement PhoneOrEmail;

@FindBy(id="password_step_input")
private WebElement NewPassword;

@FindBy(name="websubmit")
private WebElement SubmitCTA;

public void FillForm (PersonModel user) {
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
    
	try {
		wait.wait(5000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	};
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
