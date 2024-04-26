package corbett_siku;

import java.util.HashMap;

public class DataProfile1 {
	
	public static String NumberOfAdultsFromExcel;
	public static String nameOfFirstPersonFromExcel;
	public static String ageOfFirstPersonFromExcel;
	public static String genderOfFirstPersonFromExcel;
	public static String nationalityOfFirstPersonFromExcel;
	public static String countryFirstPerson;
	public static String IdTypeOfFirstPerson;
	public static String IdNumberOfFirstPerson;
	public static String NameOfSecondPerson;
	public static String AgeOfSecondPerson;
	public static String GenderOfSecondPerson;
	public static String NationalityOfSecondPerson;
	public static String countrySecondPerson;
	public static String IdTypeOfSecondPerson;
	public static String IdNumberOfSecondPerson;
	public static String NameOfThirdPerson;
	public static String AgeOfThirdPerson;
	public static String GenderOfThirdPerson;
	public static String NationalityOfThirdPerson;
	public static String countryThirdPerson;
	public static String IdTypeOfThirdPerson;
	public static String IdNumberOfThirdPerson;
	public static String NameOfFourthPerson;
	public static String AgeOfFourthPerson;
	public static String GenderOfFourthPerson;
	public static String NationalityOfFourthPerson;
	public static String countryFourthPerson;
	public static String IdTypeOfFourthPerson;
	public static String IdNumberOfFourthPerson;
	public static String NameOfFifthPerson;
	public static String AgeOfFifthPerson;
	public static String GenderOfFifthPerson;
	public static String NationalityOfFifthPerson;
	public static String countryFifthPerson;
	public static String IdTypeOfFifthPerson;
	public static String IdNumberOfFifthPerson;
	public static String NameOfSixthPerson;
	public static String AgeOfSixthPerson;
	public static String GenderOfSixthPerson;
	public static String NationalityOfSixthPerson;
	public static String countrySixthPerson;
	public static String IdTypeOfSixthPerson;
	public static String IdNumberOfSixthPerson;
	public static String mobileNumber;
	public static String probabilityOfMakingErrorInName;


	public DataProfile1() {

		HashMap<String, String> test = returnData();
		
		NumberOfAdultsFromExcel = test.get("NumberOfAdultsFromExcel");
	
		nameOfFirstPersonFromExcel = test.get("nameOfFirstPersonFromExcel");
		ageOfFirstPersonFromExcel = test.get("ageOfFirstPersonFromExcel");
		genderOfFirstPersonFromExcel = test.get("genderOfFirstPersonFromExcel");
		nationalityOfFirstPersonFromExcel = test.get("nationalityOfFirstPersonFromExcel");
		IdTypeOfFirstPerson = test.get("IdTypeOfFirstPerson");
		IdNumberOfFirstPerson = test.get("IdNumberOfFirstPerson");
		countryFirstPerson = test.get("countryFirstPerson");

		NameOfSecondPerson = test.get("NameOfSecondPerson");
		AgeOfSecondPerson = test.get("AgeOfSecondPerson");
		GenderOfSecondPerson = test.get("GenderOfSecondPerson");
		NationalityOfSecondPerson = test.get("NationalityOfSecondPerson");
		IdTypeOfSecondPerson = test.get("IdTypeOfSecondPerson");
		IdNumberOfSecondPerson = test.get("IdNumberOfSecondPerson");
		countrySecondPerson = test.get("countrySecondPerson");

		NameOfThirdPerson = test.get("NameOfThirdPerson");
		AgeOfThirdPerson = test.get("AgeOfThirdPerson");
		GenderOfThirdPerson = test.get("GenderOfThirdPerson");
		NationalityOfThirdPerson = test.get("NationalityOfThirdPerson");
		IdTypeOfThirdPerson = test.get("IdTypeOfThirdPerson");
		IdNumberOfThirdPerson = test.get("IdNumberOfThirdPerson");
		countryThirdPerson = test.get("countryThirdPerson");

		NameOfFourthPerson = test.get("NameOfFourthPerson");
		AgeOfFourthPerson = test.get("AgeOfFourthPerson");
		GenderOfFourthPerson = test.get("GenderOfFourthPerson");
		NationalityOfFourthPerson = test.get("NationalityOfFourthPerson");
		IdTypeOfFourthPerson = test.get("IdTypeOfFourthPerson");
		IdNumberOfFourthPerson = test.get("IdNumberOfFourthPerson");
		countryFourthPerson = test.get("countryFourthPerson");

		NameOfFifthPerson = test.get("NameOfFifthPerson");
		AgeOfFifthPerson = test.get("AgeOfFifthPerson");
		GenderOfFifthPerson = test.get("GenderOfFifthPerson");
		NationalityOfFifthPerson = test.get("NationalityOfFifthPerson");
		IdTypeOfFifthPerson = test.get("IdTypeOfFifthPerson");
		IdNumberOfFifthPerson = test.get("IdNumberOfFifthPerson");
		countryFifthPerson = test.get("countryFifthPerson");

		NameOfSixthPerson = test.get("NameOfSixthPerson");
		AgeOfSixthPerson = test.get("AgeOfSixthPerson");
		GenderOfSixthPerson = test.get("GenderOfSixthPerson");
		NationalityOfSixthPerson = test.get("NationalityOfSixthPerson");
		IdTypeOfSixthPerson = test.get("IdTypeOfSixthPerson");
		IdNumberOfSixthPerson = test.get("IdNumberOfSixthPerson");
		countrySixthPerson = test.get("countrySixthPerson");
		mobileNumber = test.get("mobileNumber");
		probabilityOfMakingErrorInName = test.get("probabilityOfMakingErrorInName");

	}

	public HashMap<String, String> returnData() {

		HashMap<String, String> map1 = new HashMap<String, String>();	
		// set number of adults
		
		map1.put("NumberOfAdultsFromExcel", "6");


		// Set First Person Details
		map1.put("nameOfFirstPersonFromExcel", "Profile One Name");
		map1.put("ageOfFirstPersonFromExcel", "33");
		map1.put("genderOfFirstPersonFromExcel", "Transgender"); // valid values are "Male", "Female","Transgender"
		map1.put("nationalityOfFirstPersonFromExcel", "Foreigner"); // valid values are
																	// "Indian","Foreigner","Student","Senior Citizen"
		map1.put("countryFirstPerson", "USA");   // valid values are "USA", "United Kingdom","Canada","Australia","Italy"
		map1.put("IdTypeOfFirstPerson", "Passport"); // valid values "Aadhar Card","Pan Card","Driving License","Passport","Student ID Card"
		map1.put("IdNumberOfFirstPerson", "P665879");

		// Second Person Details
		map1.put("NameOfSecondPerson", "Testing Name");
		map1.put("AgeOfSecondPerson", "44");
		map1.put("GenderOfSecondPerson", "Female");
		map1.put("NationalityOfSecondPerson", "Foreigner");// valid values are "Indian","Foreigner","Student","Senior Citizen"
		map1.put("countrySecondPerson", "Canada");
		map1.put("IdTypeOfSecondPerson", "Passport");
		map1.put("IdNumberOfSecondPerson", "P908758");

		// Third Person Details
		map1.put("NameOfThirdPerson", "ThirdPerson Name");
		map1.put("AgeOfThirdPerson", "33");
		map1.put("GenderOfThirdPerson", "Female");
		map1.put("NationalityOfThirdPerson", "Indian");// valid values are "Indian","Foreigner","Student","Senior Citizen"
		map1.put("countryThirdPerson", "Canada");
		map1.put("IdTypeOfThirdPerson", "Aadhar Card");
		map1.put("IdNumberOfThirdPerson", "987856459834");

		// Fourth Person Details
		map1.put("NameOfFourthPerson", "FourthPerson Name");
		map1.put("AgeOfFourthPerson", "34");
		map1.put("GenderOfFourthPerson", "Female");
		map1.put("NationalityOfFourthPerson", "Foreigner");// valid values are "Indian","Foreigner","Student","Senior Citizen"
		map1.put("countryFourthPerson", "Australia");
		map1.put("IdTypeOfFourthPerson", "Aadhar Card");
		map1.put("IdNumberOfFourthPerson", "767098167678");

		// Fifth Person Details
		map1.put("NameOfFifthPerson", "FifthPerson Name");
		map1.put("AgeOfFifthPerson", "35");
		map1.put("GenderOfFifthPerson", "Male");
		map1.put("NationalityOfFifthPerson", "Foreigner");// valid values are "Indian","Foreigner","Student","Senior Citizen"
		map1.put("countryFifthPerson", "Italy");
		map1.put("IdTypeOfFifthPerson", "Pan Card");
		map1.put("IdNumberOfFifthPerson", "ARHPK1895B");

		// Sixth Person Details
		map1.put("NameOfSixthPerson", "SixthPerson name");
		map1.put("AgeOfSixthPerson", "36");
		map1.put("GenderOfSixthPerson", "Transgender");
		map1.put("NationalityOfSixthPerson", "Indian");// valid values are "Indian","Foreigner","Student","Senior Citizen"
		map1.put("countrySixthPerson", "India");
		map1.put("IdTypeOfSixthPerson", "Student ID Card");
		map1.put("IdNumberOfSixthPerson", "01ME301");

		// set mobile number here
		map1.put("mobileNumber", "9911674753");
		map1.put("probabilityOfMakingErrorInName", "100");
		
		return map1;
	}

}
