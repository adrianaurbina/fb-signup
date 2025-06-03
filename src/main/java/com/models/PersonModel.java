package main.java.com.models;

import java.util.Calendar;
import java.util.Date;
import main.java.com.utils.EnumGender;

public class PersonModel {
	// Attributes or parameters related to an INSTANCE/OBJECT of the class PersonModel
	public String firstname;
	public String lastname;
	public String mailorphone;
	public String password;
	public Date birthdate;
	public EnumGender gender;

	// Methods or behaviors related to an INSTANCE/OBJECT of the class PersonModel
	public void talk() {
		System.out.println("Hablando");
	}

	public void run() {
		System.out.println("Corriendo");
	}

	// Constructor
	public PersonModel(){
		objectCounter++;
	}

	// Other static methods and parameters that returns a predefined Person (are related directly to the Class, not to an instance of such class)
	public static int objectCounter = 0;

	public static PersonModel returnDefaultPersonObj(boolean isWoman) {
		Calendar cal = Calendar.getInstance();
		cal.set(1995, Calendar.AUGUST, 03);
		PersonModel user = new PersonModel();
		user.firstname = isWoman ? "Adriana" : "Adrián";
		user.lastname = "Urbina";
		user.mailorphone = "adriana.urbina@unosquare.com";
		user.password = "Bank1234#";
		user.birthdate = cal.getTime();
		user.gender = EnumGender.Female;

		return user;
	}
	
}
