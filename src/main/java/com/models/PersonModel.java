package main.java.com.models;

import java.util.Calendar;
import java.util.Date;
import main.java.com.utils.EnumGender;

public class PersonModel {
	public String firstname;
	public String lastname;
	public String mailorphone;
	public String password;
	public Date birthdate;
	public EnumGender gender;

	public static PersonModel returnDefaultPersonObj() {
		Calendar cal = Calendar.getInstance();
		cal.set(1995, Calendar.AUGUST, 03);
		PersonModel user = new PersonModel();
		user.firstname = "Adriana";
		user.lastname = "Urbina";
		user.mailorphone = "adriana.urbina@unosquare.com";
		user.password = "Bank1234#";
		user.birthdate = cal.getTime();
		user.gender = EnumGender.Female;

		return user;
	}
	
}
