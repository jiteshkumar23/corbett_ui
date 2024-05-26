package corbett_siku;

import java.util.HashMap;

public class DataProfile1 {
	
	public static String NumberOfAdultsFromExcel;
	public static String numberOfRooms;
	public static String numberOfChildren;
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
	public static String probabilityOfMakingErrorInId;
	public static String checkInDate;
	public static String checkOutDate;
	public static String roomPrioirty;

	public DataProfile1() {

		HashMap<String, String> test = returnData();
		
		checkInDate = test.get("checkInDate");
		checkOutDate = test.get("checkOutDate");
		
		NumberOfAdultsFromExcel = test.get("NumberOfAdultsFromExcel");
		numberOfRooms = test.get("numberOfRooms");
		numberOfChildren = test.get("numberOfChildren");
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
		probabilityOfMakingErrorInId = test.get("probabilityOfMakingErrorInId");
		roomPrioirty = test.get("roomPrioirty");
		
	}

	public HashMap<String, String> returnData() {

		HashMap<String, String> map1 = new HashMap<String, String>();	
	
		map1.put("checkInDate", "2024-05-27");
		map1.put("checkOutDate", "2024-05-28");
		
		// set number of rooms
		map1.put("numberOfRooms", "1");
		// set number of adults
		map1.put("NumberOfAdultsFromExcel", "1");
		// set number of children
		map1.put("numberOfChildren", "0");// valid values are "0", "1","2"
		
		//Set the room to be booked
		//Bijrani
		//Gairal
		//Halduparao
		//Jhirna
		//Morghati
		//Mudiapani
		//Pakhro
		//Rathuwadhab
		map1.put("roomPrioirty", "Pakhro");
		
		
		
		// Set First Person Details
		map1.put("nameOfFirstPersonFromExcel", "Profile One Name");
		map1.put("ageOfFirstPersonFromExcel", "33");
		map1.put("genderOfFirstPersonFromExcel", "Transgender"); // valid values are "Male", "Female","Transgender"
		map1.put("nationalityOfFirstPersonFromExcel", "Indian"); // valid values are
																	// "Indian","Foreigner","Student","Senior Citizen"
		map1.put("countryFirstPerson", "India");   // valid values are "USA", "United Kingdom","Canada","Australia","Italy"
		map1.put("IdTypeOfFirstPerson", "Passport"); // valid values "Aadhar Card","Pan Card","Driving License","Passport","Student ID Card"
		map1.put("IdNumberOfFirstPerson", "P656789");

		// Second Person Details
		map1.put("NameOfSecondPerson", "Testing Name");
		map1.put("AgeOfSecondPerson", "44");
		map1.put("GenderOfSecondPerson", "Female");
		map1.put("NationalityOfSecondPerson", "Indian");// valid values are "Indian","Foreigner","Student","Senior Citizen"
		map1.put("countrySecondPerson", "India");
		map1.put("IdTypeOfSecondPerson", "Passport");
		map1.put("IdNumberOfSecondPerson", "P537894");

		// Third Person Details
		map1.put("NameOfThirdPerson", "ThirdPerson Name");
		map1.put("AgeOfThirdPerson", "33");
		map1.put("GenderOfThirdPerson", "Female");
		map1.put("NationalityOfThirdPerson", "Foreigner");// valid values are "Indian","Foreigner","Student","Senior Citizen"
		map1.put("countryThirdPerson", "USA");
		map1.put("IdTypeOfThirdPerson", "Passport");
		map1.put("IdNumberOfThirdPerson", "P671098");

		// Fourth Person Details
		map1.put("NameOfFourthPerson", "FourthPerson Name");
		map1.put("AgeOfFourthPerson", "34");
		map1.put("GenderOfFourthPerson", "Female");
		map1.put("NationalityOfFourthPerson", "Student");// valid values are "Indian","Foreigner","Student","Senior Citizen"
		map1.put("countryFourthPerson", "India");
		map1.put("IdTypeOfFourthPerson", "Passport");
		map1.put("IdNumberOfFourthPerson", "U869096");

		// Fifth Person Details
		map1.put("NameOfFifthPerson", "FifthPerson Name");
		map1.put("AgeOfFifthPerson", "35");
		map1.put("GenderOfFifthPerson", "Male");
		map1.put("NationalityOfFifthPerson", "Senior Citizen");// valid values are "Indian","Foreigner","Student","Senior Citizen"
		map1.put("countryFifthPerson", "India");
		map1.put("IdTypeOfFifthPerson", "Passport");
		map1.put("IdNumberOfFifthPerson", "U869044");

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
		map1.put("probabilityOfMakingErrorInId", "100");
		
		
		return map1;
	}

}
