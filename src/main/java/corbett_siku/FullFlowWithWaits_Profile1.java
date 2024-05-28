package corbett_siku;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import javax.swing.JFrame;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Mouse;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class FullFlowWithWaits_Profile1 extends DataProfile1 {

	public static int intNumberOfAdultsFromExcel;
	public static Screen screen = new Screen();
	public static Screen screen_1a = new Screen();
	public static Screen screen_2 = new Screen();
	public static Screen screen_3 = new Screen();
	public static Screen screen_4 = new Screen();
	public static Screen screen_5 = new Screen();
	public static Screen screen_6 = new Screen();
	public static String imagePath = System.getProperty("user.dir") + File.separator + "images" + File.separator;
	public static Random rand;
	public static boolean nationalityDropDownDisplayed;
	public int intNumberOfAdults1 = Integer.parseInt(NumberOfAdultsFromExcel);
	public int intNumberOfRooms = Integer.parseInt(numberOfRooms);
	public int intnumberOfChildren = Integer.parseInt(numberOfChildren);
	public boolean keyCombinationPressed = false;

	@BeforeSuite
	@Parameters("suiteName")
	public void waitForKeyCombination(String suiteName) {
		if ("MySpecificSuite".equals(suiteName)) {
		JFrame frame = new JFrame();
		frame.setSize(200, 200);
		frame.setUndecorated(true); // Remove window decorations
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Terminate the program when closing the frame

		// Calculate frame location
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gs = ge.getScreenDevices();
		Rectangle bounds = gs[0].getDefaultConfiguration().getBounds();
		int screenWidth = bounds.width;
		int screenHeight = bounds.height;
		int frameWidth = frame.getWidth();
		int frameHeight = frame.getHeight();
		int x = 0; // Left side of the screen
		int y = screenHeight - frameHeight; // Bottom of the screen

		frame.setLocation(x, y);
		frame.setAlwaysOnTop(true); // Make the frame always on top
		frame.setVisible(true);
		frame.requestFocus(); // Request focus for the frame

		frame.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_B) {
					keyCombinationPressed = true;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});

		// Thread to periodically bring the frame to the front
		new Thread(() -> {
			while (!keyCombinationPressed) {
				if (!frame.isFocused()) {
					frame.toFront();
				}
				try {
					Thread.sleep(500); // Adjust the sleep duration as needed
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		// Wait for the key combination to be pressed
		while (!keyCombinationPressed) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		frame.dispose(); // Close the frame once the key combination is pressed
	}
	}
	@Test
	public void firstPage() throws FindFailed, InterruptedException {

		// timeout in seconds below

		System.out.println("Hot key has been pressed !!!");
		System.out.println("###################   Starting   ###################");
		System.out.println("");

		sikuClickOnThis("checkindate.png", 120, 0.7);

		System.out.println(checkInDate);
		System.out.println(checkOutDate);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate checkInDateObj = LocalDate.parse(checkInDate, formatter);
		LocalDate checkOutDateObj = LocalDate.parse(checkOutDate, formatter);
		LocalDate currentDate = LocalDate.now();

		long differenceInDaysCheckInAndCurrent = ChronoUnit.DAYS.between(currentDate, checkInDateObj);
		long differenceInDaysCheckOutAndCheckIn = ChronoUnit.DAYS.between(checkInDateObj, checkOutDateObj);

		int intdifferenceInDaysCheckInAndCurrent = (int) differenceInDaysCheckInAndCurrent;

		int intdifferenceInDaysCheckOutAndCheckIn = (int) differenceInDaysCheckOutAndCheckIn;

		System.out.println(intdifferenceInDaysCheckInAndCurrent);
		System.out.println(intdifferenceInDaysCheckOutAndCheckIn);

		pressRightArrow(intdifferenceInDaysCheckInAndCurrent);
//		pressEnter(1);
		Thread.sleep(200);
		screen.type("i", KeyModifier.ALT);
		Thread.sleep(200);
		
		pressTab(1);
		pressRightArrow(intdifferenceInDaysCheckOutAndCheckIn - 1);
//		pressEnter(1);
		Thread.sleep(200);
		screen.type("o", KeyModifier.ALT);
		Thread.sleep(200);
		pressTab(1);

		switch (intNumberOfRooms) {
		case 1:
			System.out.println("Do nothing for number of rooms");
			break;
		case 2:
			pressDownArrowKey(1);
			break;
		case 3:
			pressDownArrowKey(2);
			break;
		}

		pressTab(1);

		switch (intNumberOfAdults1) {
		case 1:
			pressUpArrowKey(1);
			break;
		case 2:
			System.out.println("Do nothing for number of adults");
			break;
		case 3:
			pressDownArrowKey(1);
			break;
		case 4:
			pressDownArrowKey(2);
			break;
		case 5:
			pressDownArrowKey(3);
			break;
		case 6:
			pressDownArrowKey(4);
			break;
		}

		pressTab(1);

		switch (intnumberOfChildren) {
		case 0:
			System.out.println("Do nothing for number of children");
			break;
		case 1:
			pressDownArrowKey(1);
			break;
		case 2:
			pressDownArrowKey(2);
			break;
		}

		System.out.println("Number of adults is -->" + intNumberOfAdults1);

		if (intNumberOfAdults1 >= 1) {
			pressTab(1);
			selectPaxType(nationalityOfFirstPersonFromExcel);
		}

		if (intNumberOfAdults1 >= 2) {
			pressTab(1);
			selectPaxType(NationalityOfSecondPerson);
		}
		if (intNumberOfAdults1 >= 3) {
			pressTab(1);
			selectPaxType(NationalityOfThirdPerson);
		}
		if (intNumberOfAdults1 >= 4) {
			pressTab(1);
			selectPaxType(NationalityOfFourthPerson);
		}
		if (intNumberOfAdults1 >= 5) {
			pressTab(1);
			selectPaxType(NationalityOfFifthPerson);
		}
		if (intNumberOfAdults1 >= 6) {
			pressTab(1);
			selectPaxType(NationalityOfSixthPerson);
		}

		pressTab(1);
		pressEnter(1);

		Thread.sleep(1000);

		switch (roomPrioirty) {
		case "Bijrani":
			System.out.println("roomPrioirty selected is " + roomPrioirty);
			screen.type("1", KeyModifier.SHIFT);
			break;
		case "Gairal New":
			System.out.println("roomPrioirty selected is " + roomPrioirty);
			screen.type("2", KeyModifier.SHIFT);
			break;
		case "Halduparao":
			System.out.println("roomPrioirty selected is " + roomPrioirty);
			screen.type("3", KeyModifier.SHIFT);
			break;
		case "Jhirna":
			System.out.println("roomPrioirty selected is " + roomPrioirty);
			screen.type("4", KeyModifier.SHIFT);
			break;
		case "Morghati":
			System.out.println("roomPrioirty selected is " + roomPrioirty);
			screen.type("5", KeyModifier.SHIFT);
			break;
		case "Mudiapani":
			System.out.println("roomPrioirty selected is " + roomPrioirty);
			screen.type("6", KeyModifier.SHIFT);
			break;
		case "Pakhro":
			System.out.println("roomPrioirty selected is " + roomPrioirty);
			screen.type("7", KeyModifier.SHIFT);
			break;
		case "Rathuwadhab":
			System.out.println("roomPrioirty selected is " + roomPrioirty);
			screen.type("8", KeyModifier.SHIFT);
			break;
		case "Gairal Dormitory":
			System.out.println("roomPrioirty selected is " + roomPrioirty);
			screen.type("9", KeyModifier.SHIFT);
			break;
		case "Hutment-Dhikala":
			System.out.println("roomPrioirty selected is " + roomPrioirty);
			screen.type("0", KeyModifier.SHIFT);
			break;
		case "Cabin 4ABC-Dhikala":
			System.out.println("roomPrioirty selected is " + roomPrioirty);
			screen.type("0", KeyModifier.ALT);
			break;
		case "New-Dhikala":
			System.out.println("roomPrioirty selected is " + roomPrioirty);
			screen.type("1", KeyModifier.ALT);
			break;
		case "Annexi-Dhikala FRH-1/2/3/4/6":
			System.out.println("roomPrioirty selected is " + roomPrioirty);
			screen.type("2", KeyModifier.ALT);
			break;
		case "Annexi-Dhikala FRH- 5/7":
			System.out.println("roomPrioirty selected is " + roomPrioirty);
			screen.type("3", KeyModifier.ALT);
			break;
		case "Sarpduli FRH":
			System.out.println("roomPrioirty selected is " + roomPrioirty);
			screen.type("4", KeyModifier.ALT);
			break;
		case "Sarpduli Dormitory":
			System.out.println("roomPrioirty selected is " + roomPrioirty);
			screen.type("5", KeyModifier.ALT);
			break;
		case "Dhela":
			System.out.println("roomPrioirty selected is " + roomPrioirty);
			screen.type("6", KeyModifier.ALT);
			break;
		case "Sultan":
			System.out.println("roomPrioirty selected is " + roomPrioirty);
			screen.type("7", KeyModifier.ALT);
			break;
		case "Mailani":
			System.out.println("roomPrioirty selected is " + roomPrioirty);
			screen.type("8", KeyModifier.ALT);
			break;
		case "Loghut-Dhikala":
			System.out.println("roomPrioirty selected is " + roomPrioirty);
			screen.type("9", KeyModifier.ALT);
			break;
		}
	}

	@Test
	public void FillMemberDetails() throws Exception {

		if (nationalityOfFirstPersonFromExcel.toLowerCase().equalsIgnoreCase("foreigner")
				|| NationalityOfSecondPerson.toLowerCase().equalsIgnoreCase("foreigner")
				|| NationalityOfThirdPerson.toLowerCase().equalsIgnoreCase("foreigner")
				|| NationalityOfFourthPerson.toLowerCase().equalsIgnoreCase("foreigner")
				|| NationalityOfFifthPerson.toLowerCase().equalsIgnoreCase("foreigner")
				|| NationalityOfSixthPerson.toLowerCase().equalsIgnoreCase("foreigner"))

		{
			nationalityDropDownDisplayed = true;
		}
		System.out.println("nationalityDropDownDisplayed is -->" + nationalityDropDownDisplayed);
		
		try {
			sikuClickOnThis("point345.png", 2, 0.4);
		} catch (Exception e) {
			System.out.println("Exception" + e);
		}
		System.out.println("Image clicked");

		clickOnCenter(screen);

		scrollUpToTop(4);

		// sikuClickOnThisWithinRegion(screen_1a, "firstNameBox.png", 206, 203, 830,
		// 96);

		sikuClickOnThis("firstNameBox.png", 10, 0.77);

		// First Person Data Input
		intNumberOfAdultsFromExcel = Integer.parseInt(NumberOfAdultsFromExcel);

		if (intNumberOfAdultsFromExcel >= 1) {

			makeRandomErrorinTypingAndCorrect(nameOfFirstPersonFromExcel, "one");

			pressTab(1);

			genderSelection(genderOfFirstPersonFromExcel);

			Thread.sleep(WaitsProfile1.delayInGenderDropdown1);

			if (nationalityDropDownDisplayed) {
				selectForeignCountry(nationalityOfFirstPersonFromExcel, "one", countryFirstPerson);
				if (nationalityOfFirstPersonFromExcel.toLowerCase().equalsIgnoreCase("foreigner")) {
					sikuClickOnThisWithScreen(screen_1a, "IDdropdown.png", 10, 0.5);
				} else {
					pressTab(1);
				}
			} else {
				pressTab(1);
			}

			selectIDType(IdTypeOfFirstPerson);

			if (nationalityOfFirstPersonFromExcel.toLowerCase().equalsIgnoreCase("foreigner")) {
				pressTab(2);
			} else {
				pressTab(1);
			}

			Thread.sleep(WaitsProfile1.delayInProofDropdown1);

			enterIDNumber(IdNumberOfFirstPerson, "one");

			pressTab(1);

			enterAge(ageOfFirstPersonFromExcel, "one");

			Thread.sleep(WaitsProfile1.person1wait);

		}

		// Second Person Data Input
		if (intNumberOfAdultsFromExcel >= 2) {
			pressTab(1);

			makeRandomErrorinTypingAndCorrect(NameOfSecondPerson, "two");

			pressTab(1);

			genderSelection(GenderOfSecondPerson);

			Thread.sleep(WaitsProfile1.delayInGenderDropdown2);

			if (nationalityDropDownDisplayed) {
				selectForeignCountry(NationalityOfSecondPerson, "two", countrySecondPerson);
				if (NationalityOfSecondPerson.toLowerCase().equalsIgnoreCase("foreigner")) {
					sikuClickOnThisWithScreen(screen_2, "IDdropdown.png", 10, 0.5);
				} else {
					pressTab(1);
				}
			} else {
				pressTab(1);
			}
			selectIDType(IdTypeOfSecondPerson);

			if (NationalityOfSecondPerson.toLowerCase().equalsIgnoreCase("foreigner")) {
				pressTab(2);
			} else {
				pressTab(1);
			}

			Thread.sleep(WaitsProfile1.delayInProofDropdown2);

			enterIDNumber(IdNumberOfSecondPerson, "two");

			pressTab(1);

			enterAge(AgeOfSecondPerson, "two");

			Thread.sleep(WaitsProfile1.person2wait);

		}

		// Third Person Data Input

		if (intNumberOfAdultsFromExcel >= 3) {

			pressTab(1);

			makeRandomErrorinTypingAndCorrect(NameOfThirdPerson, "three");

			pressTab(1);

			genderSelection(GenderOfThirdPerson);

			Thread.sleep(WaitsProfile1.delayInGenderDropdown3);

			if (nationalityDropDownDisplayed) {
				selectForeignCountry(NationalityOfThirdPerson, "three", countryThirdPerson);
				if (NationalityOfThirdPerson.toLowerCase().equalsIgnoreCase("foreigner")) {
					sikuClickOnThisWithScreen(screen_3, "IDdropdown.png", 10, 0.5);
				} else {
					pressTab(1);
				}
			} else {
				pressTab(1);
			}
			selectIDType(IdTypeOfThirdPerson);

			if (NationalityOfThirdPerson.toLowerCase().equalsIgnoreCase("foreigner")) {
				pressTab(2);
			} else {
				pressTab(1);
			}

			Thread.sleep(WaitsProfile1.delayInProofDropdown3);

			enterIDNumber(IdNumberOfThirdPerson, "three");

			pressTab(1);

			enterAge(AgeOfThirdPerson, "three");

			Thread.sleep(WaitsProfile1.person3wait);

		}

		// Fourth Person Data Input
		if (intNumberOfAdultsFromExcel >= 4) {

			pressTab(1);

			makeRandomErrorinTypingAndCorrect(NameOfFourthPerson, "four");

			pressTab(1);

			genderSelection(GenderOfFourthPerson);

			Thread.sleep(WaitsProfile1.delayInGenderDropdown4);

			if (nationalityDropDownDisplayed) {
				selectForeignCountry(NationalityOfFourthPerson, "four", countryFourthPerson);
				if (NationalityOfFourthPerson.toLowerCase().equalsIgnoreCase("foreigner")) {
					sikuClickOnThisWithScreen(screen_4, "IDdropdown.png", 10, 0.5);
				} else {
					pressTab(1);
				}
			} else {
				pressTab(1);
			}
			selectIDType(IdTypeOfFourthPerson);

			if (NationalityOfFourthPerson.toLowerCase().equalsIgnoreCase("foreigner")) {
				pressTab(2);
			} else {
				pressTab(1);
			}

			Thread.sleep(WaitsProfile1.delayInProofDropdown4);

			enterIDNumber(IdNumberOfFourthPerson, "four");

			pressTab(1);

			enterAge(AgeOfFourthPerson, "four");

			Thread.sleep(WaitsProfile1.person4wait);

		}

		// Fifth Person Data Input
		if (intNumberOfAdultsFromExcel >= 5) {

			pressTab(1);

			makeRandomErrorinTypingAndCorrect(NameOfFifthPerson, "five");

			pressTab(1);

			genderSelection(GenderOfFifthPerson);

			Thread.sleep(WaitsProfile1.delayInGenderDropdown5);

			if (nationalityDropDownDisplayed) {
				selectForeignCountry(NationalityOfFifthPerson, "five", countryFifthPerson);
				if (NationalityOfFifthPerson.toLowerCase().equalsIgnoreCase("foreigner")) {
					sikuClickOnThisWithScreen(screen_5, "IDdropdown.png", 10, 0.5);
				} else {
					pressTab(1);
				}
			} else {
				pressTab(1);
			}
			selectIDType(IdTypeOfFifthPerson);

			if (NationalityOfFifthPerson.toLowerCase().equalsIgnoreCase("foreigner")) {
				pressTab(2);
			} else {
				pressTab(1);
			}

			Thread.sleep(WaitsProfile1.delayInProofDropdown5);

			enterIDNumber(IdNumberOfFifthPerson, "five");

			pressTab(1);

			enterAge(AgeOfFifthPerson, "five");

			Thread.sleep(WaitsProfile1.person5wait);

		}

		// Sixth Person Data Input
		if (intNumberOfAdultsFromExcel >= 6) {

			pressTab(1);

			makeRandomErrorinTypingAndCorrect(NameOfSixthPerson, "six");

			pressTab(1);

			genderSelection(GenderOfSixthPerson);

			Thread.sleep(WaitsProfile1.delayInGenderDropdown6);
			if (nationalityDropDownDisplayed) {
				selectForeignCountry(NationalityOfSixthPerson, "six", countrySixthPerson);
				if (NationalityOfSixthPerson.toLowerCase().equalsIgnoreCase("foreigner")) {
					sikuClickOnThisWithScreen(screen_6, "IDdropdown.png", 10, 0.5);
				} else {
					pressTab(1);
				}
			} else {
				pressTab(1);
			}

			selectIDType(IdTypeOfSixthPerson);

			if (NationalityOfSixthPerson.toLowerCase().equalsIgnoreCase("foreigner")) {
				pressTab(2);
			} else {
				pressTab(1);
			}

			Thread.sleep(WaitsProfile1.delayInProofDropdown6);

			enterIDNumber(IdNumberOfSixthPerson, "six");

			pressTab(1);

			enterAge(AgeOfSixthPerson, "six");

			Thread.sleep(WaitsProfile1.person6wait);

		}

	}

	private void clickOnCenter(Screen screen) throws FindFailed {
		// Get the screen resolution
		int screenWidth = screen.getW();
		int screenHeight = screen.getH();

		// Calculate the center of the screen
		int centerX = screenWidth / 2;
		int centerY = screenHeight / 2;

		// Create a Location object for the center
		Location center = new Location(centerX, centerY);

		// Click at the center of the screen
		screen.click(center);

	}

	private void selectPaxType(String nationalityOfPersonFromExcel) throws InterruptedException {

		if (nationalityOfPersonFromExcel.equalsIgnoreCase("Indian")) {
			pressDownArrowKey(1);
		} else if (nationalityOfPersonFromExcel.equalsIgnoreCase("Foreigner")) {
			pressDownArrowKey(2);
		} else if (nationalityOfPersonFromExcel.equalsIgnoreCase("Student")) {
			pressDownArrowKey(3);
		} else if (nationalityOfPersonFromExcel.equalsIgnoreCase("Senior Citizen")) {
			pressDownArrowKey(4);
		}

	}

	@Test
	public void EnterMobile() throws Exception {

		scrollDownToEnd(2);
		pressTab(2);
		int waitTime = 500;
		waitTime = WaitsProfile1.totalTimeForTypingMobileNumber;

		int count = mobileNumber.length();
		int timePerCharacter = waitTime / count;
		String[] str = mobileNumber.split("");

		for (int i = 0; i < count; i++) {

			screen.type(str[i]);
			Thread.sleep(timePerCharacter);

		}

	}

	public static void sikuClickOnThis(String specificImagePath, int waitTime, double match) throws FindFailed {

		// System.out.println(imagePath);
		Pattern imagePattern = new Pattern(imagePath + specificImagePath).similar(match);
		screen.wait(imagePattern, waitTime);
		screen.click(imagePattern);

	}

	public static void sikuClickOnThisWithScreen(Screen screen, String specificImagePath, int waitTime, double match)
			throws FindFailed, InterruptedException {

		// System.out.println(imagePath);
		Pattern imagePattern = new Pattern(imagePath + specificImagePath).similar(match);
		screen.wait(imagePattern, waitTime);
		screen.click(imagePattern);
		Thread.sleep(50);
	}

	public static void sikuWaitForThisImage(String specificImagePath, int waitTime, double match) throws FindFailed {

		// System.out.println(imagePath);
		Pattern imagePattern = new Pattern(imagePath + specificImagePath).similar(match);
		screen.wait(imagePattern, waitTime);

	}

	public static void sikuClickOnThisAndEnterText(String specificImagePath, String text, int timeToType)
			throws FindFailed, InterruptedException {
//		System.out.println(imagePath);
//		System.out.println(specificImagePath);
//		String fullPath = imagePath +specificImagePath;
//		System.out.println(fullPath);
		Pattern imagePattern = new Pattern(imagePath + specificImagePath).similar(0.4);
		screen.wait(imagePattern, 20);
		screen.click(imagePattern);

		String[] str = text.split("");
		int dividedWait = timeToType / str.length;
		for (String str1 : str) {
			screen.type(str1);
			int randomNumber = randomNumberBetweenMinAndMax(dividedWait, dividedWait + 15);
			Thread.sleep(randomNumber);
		}
	}

	public static void sikuClickOnThisWithTargetOffset(String specificImagePath, int targetX, int targetY,
			double offset) throws FindFailed {

		String fullImagePath = imagePath + specificImagePath;
		Pattern targetImagePattern = new Pattern(fullImagePath).targetOffset(targetX, targetY).similar(offset);

		try {
			// Find the target image on the screen
			Match match = screen.find(targetImagePattern);
			// Click on the found match
			match.click();
		} catch (FindFailed e) {
			System.out.println("Element not found");
			e.printStackTrace();
		}

	}

	public static void sikuClickOnThisWithinRegion(Screen screen, String specificImagePath, int regionX, int regionY,
			int regionWidth, int regionHeight) throws FindFailed, InterruptedException {

		String fullImagePath = imagePath + specificImagePath;
		// Pattern targetImagePattern = new Pattern(fullImagePath).targetOffset(targetX,
		// targetY).similar(offset);

		try {
			// Define the region on the screen
			Region region = new Region(regionX, regionY, regionWidth, regionHeight);

			// Set the search region
			screen.setRect(region);

			// Find and click on the dropdown within the defined region

			Pattern dropdownPattern = new Pattern(fullImagePath);
			screen.wait(dropdownPattern, 10);
			screen.click(dropdownPattern);

			// You can further interact with the dropdown or its options as needed

		} catch (FindFailed e) {
			e.printStackTrace();
		}

	}

	public static int randomNumberBetweenMinAndMax(int min, int max) {
		// Create an instance of the Random1 class
		rand = new Random();

		// Generate a random number between 10 and 50
		int randomNumber = rand.nextInt(max - min + 1) + min; // The range is [0, 41), so we add 10 to shift it to [10,
																// 50]

		// Print the random number
		// System.out.println("Random number between "+min+" and "+max+": " +
		// randomNumber);
		return randomNumber;

	}

	public static void randomMouseMovement() throws FindFailed, InterruptedException {

		// Get the current mouse position
		Location currentPos = Mouse.at();

		// Generate random coordinates for the new position
		int randomX = (int) (Math.random() * screen.getBounds().width);
		int randomY = (int) (Math.random() * screen.getBounds().height);

		// Move the mouse to the random position
		screen.mouseMove(currentPos.offset(randomX, randomY));
		screen.mouseMove(currentPos);
		// Wait for a moment to see the movement
		Thread.sleep(200);

	}

	public static void pressTab(int count) {
		for (int i = 1; i <= count; i++) {
			screen.type(Key.TAB);
		}
	}

	public static void pressEnter(int count) {
		for (int i = 1; i <= count; i++) {
			screen.type(Key.ENTER);
		}
	}

	public static void scrollDownToEnd(int count) {

		for (int i = 1; i <= count; i++) {
			screen.type(Key.PAGE_DOWN);
		}

	}

	public static void scrollUpToTop(int count) throws InterruptedException {

		// screen.type(Key.HOME, KeyModifier.CTRL);

		for (int i = 1; i <= count; i++) {
			screen.type(Key.PAGE_UP);
			Thread.sleep(50);
		}

	}

	public static void pressRightArrow(int count) {
		for (int i = 1; i <= count; i++) {
			screen.type(Key.RIGHT);
		}

	}

	public static void makeRandomErrorinTypingAndCorrect(String text, String personNumber) throws InterruptedException {
		int count = text.length();
		int newRandom = randomNumberBetweenMinAndMax(1, count);

		int waitTime = 500;
		switch (personNumber) {
		case "one":
			waitTime = WaitsProfile1.totalTimeForTypingName1;
			break;
		case "two":
			waitTime = WaitsProfile1.totalTimeForTypingName2;
			break;
		case "three":
			waitTime = WaitsProfile1.totalTimeForTypingName3;
			break;
		case "four":
			waitTime = WaitsProfile1.totalTimeForTypingName4;
			break;
		case "five":
			waitTime = WaitsProfile1.totalTimeForTypingName5;
			break;
		case "six":
			waitTime = WaitsProfile1.totalTimeForTypingName6;
			break;
		}
		// System.out.println("Name wait time is : "+waitTime);

		int timePerCharacter = waitTime / count;
		String[] str = text.split("");

		for (int i = 0; i < newRandom - 1; i++) {

			screen.type(str[i]);
			Thread.sleep(timePerCharacter);

		}
		System.out.println(probabilityOfMakingErrorInName);
		int newR = randomNumberBetweenMinAndMax(1, 100);
		if (newR <= Integer.parseInt(probabilityOfMakingErrorInName)) {
			Random random = new Random();
			char[] alphabets = "abcdefghijklmnopqrstuvwxyz".toCharArray();
			int randomIndex = random.nextInt(alphabets.length);
			char randomAlphabet = alphabets[randomIndex];

			screen.type(String.valueOf(randomAlphabet));
			Thread.sleep(250);

			// Simulate pressing the "Backspace" key to delete the last character
			screen.type(Key.BACKSPACE);
			Thread.sleep(100);
		}

		for (int i = newRandom - 1; i < count; i++) {

			screen.type(str[i]);
			Thread.sleep(timePerCharacter);

		}
		Thread.sleep(newR + 23);
	}

	public static void genderSelection(String gender) throws InterruptedException {
		if (gender.toLowerCase().equalsIgnoreCase("female")) {
			screen.type(Key.RIGHT);
			Thread.sleep(58);
		}

		else if (gender.toLowerCase().equalsIgnoreCase("transgender")) {
			screen.type(Key.RIGHT);
			screen.type(Key.RIGHT);
		}

	}

	public static void selectIDType(String IdTypeOfPerson) throws InterruptedException {

		if (IdTypeOfPerson.toLowerCase().contains("aadhar")) {
			pressDownArrowKey(1);
		}

		else if (IdTypeOfPerson.toLowerCase().contains("driving")) {
			pressDownArrowKey(2);
		} else if (IdTypeOfPerson.toLowerCase().contains("passport")) {
			pressDownArrowKey(3);
		} else if (IdTypeOfPerson.toLowerCase().contains("pan")) {
			pressDownArrowKey(4);
		} else if (IdTypeOfPerson.toLowerCase().contains("student")) {
			pressDownArrowKey(5);
		}
	}

	public static void enterIDNumber(String IdNumberOfPerson, String personNumber) throws InterruptedException {
		int count = IdNumberOfPerson.length();
		String[] str = IdNumberOfPerson.split("");
		int newRandom = randomNumberBetweenMinAndMax(1, count);

		int waitTime = 500;

		switch (personNumber) {
		case "one":
			waitTime = WaitsProfile1.totalTimeForTypingID1;
			break;
		case "two":
			waitTime = WaitsProfile1.totalTimeForTypingID2;
			break;
		case "three":
			waitTime = WaitsProfile1.totalTimeForTypingID3;
			break;
		case "four":
			waitTime = WaitsProfile1.totalTimeForTypingID4;
			break;
		case "five":
			waitTime = WaitsProfile1.totalTimeForTypingID5;
			break;
		case "six":
			waitTime = WaitsProfile1.totalTimeForTypingID6;
			break;
		}
		// System.out.println("Name wait time is : "+waitTime);

		int timePerCharacter = waitTime / count;

		for (int i = 0; i < newRandom - 1; i++) {

			screen.type(str[i]);
			Thread.sleep(timePerCharacter);

		}
		System.out.println(probabilityOfMakingErrorInId);
		int newR = randomNumberBetweenMinAndMax(1, 100);
		if (newR <= Integer.parseInt(probabilityOfMakingErrorInId)) {

			int newRandom1 = randomNumberBetweenMinAndMax(0, 9);

			screen.type(String.valueOf(newRandom1));
			Thread.sleep(210);

			// Simulate pressing the "Backspace" key to delete the last character
			screen.type(Key.BACKSPACE);
			Thread.sleep(100);
		}

		for (int i = newRandom - 1; i < count; i++) {

			screen.type(str[i]);
			Thread.sleep(timePerCharacter);

		}
		Thread.sleep(newR + 27);
	}

	public static void enterAge(String ageOfPersonFromExcel, String personNumber) throws InterruptedException {
		int count = ageOfPersonFromExcel.length();
		String[] str = ageOfPersonFromExcel.split("");

		int waitTime = 200;

		switch (personNumber) {
		case "one":
			waitTime = WaitsProfile1.totalTimeForTypingAge1;
			break;
		case "two":
			waitTime = WaitsProfile1.totalTimeForTypingAge2;
			break;
		case "three":
			waitTime = WaitsProfile1.totalTimeForTypingAge3;
			break;
		case "four":
			waitTime = WaitsProfile1.totalTimeForTypingAge4;
			break;
		case "five":
			waitTime = WaitsProfile1.totalTimeForTypingAge5;
			break;
		case "six":
			waitTime = WaitsProfile1.totalTimeForTypingAge6;
			break;
		}
		// System.out.println("Name wait time is : "+waitTime);

		int timePerCharacter = waitTime / count;

		for (int i = 0; i < count; i++) {

			screen.type(str[i]);
			Thread.sleep(timePerCharacter);

		}

	}

	public static void pressRightKey(int times) throws InterruptedException {
		for (int i = 0; i < times; i++) {
			screen.type(Key.RIGHT);
			Thread.sleep(20);
		}
	}

	public static void pressDownArrowKey(int times) throws InterruptedException {
		for (int i = 0; i < times; i++) {
			screen.type(Key.DOWN);
			Thread.sleep(75);
		}
	}

	public static void pressUpArrowKey(int times) throws InterruptedException {
		for (int i = 0; i < times; i++) {
			screen.type(Key.UP);
			Thread.sleep(75);
		}
	}

	public static void pressPageUpKey(int times) throws InterruptedException {
		for (int i = 0; i < times; i++) {
			screen.type(Key.PAGE_UP);
			Thread.sleep(20);
		}
	}

	private static void selectForeignCountry(String nationalityOfPersonFromExcel, String person, String countryPerson) {
		try {
			if (nationalityOfPersonFromExcel.equalsIgnoreCase("foreigner")) {

				switch (person) {
				case "one":
					sikuClickOnThisWithinRegion(screen_1a, "india.png", 107, 223, 1133, 125);
					break;
				case "two":
					sikuClickOnThisWithinRegion(screen_2, "india.png", 107, 353, 1128, 120);
					break;
				case "three":
					sikuClickOnThisWithinRegion(screen_3, "india.png", 107, 482, 1127, 117);
					break;
				case "four":
					sikuClickOnThisWithinRegion(screen_4, "india.png", 107, 611, 1127, 111);
					break;
				case "five":
					sikuClickOnThisWithinRegion(screen_5, "india.png", 107, 352, 1127, 124);
					break;
				case "six":
					sikuClickOnThisWithinRegion(screen_6, "india.png", 107, 478, 1127, 123);
					break;
				}
				System.out.println("India image clicked");

				sikuWaitForThisImage("select_country.png", 10, 0.5);

				if (countryPerson.equalsIgnoreCase("USA")) {
					System.out.println("Inside USA Selection");
					sikuClickOnThis("AForAmerica.png", 10, 0.5);
//					scrollDownToEnd(2);
//					sikuClickOnThis("USA.png", 10, 0.5);
					searchForCountryAndClickOnIt("usa");

				}

				else if (countryPerson.equalsIgnoreCase("United Kingdom")) {
					System.out.println("Inside United Kingdom Selection");
					sikuClickOnThis("UForUnitedKingdom.png", 10, 0.6);
					// sikuClickOnThis("UnitedKingdom.png", 10, 0.6);
					searchForCountryAndClickOnIt("united");
				} else if (countryPerson.equalsIgnoreCase("Canada")) {
					System.out.println("Inside Canada Selection");
					sikuClickOnThis("CForCanada.png", 10, 0.6);
					// sikuClickOnThis("Canada.png", 10, 0.6);
					searchForCountryAndClickOnIt("canada");
				} else if (countryPerson.equalsIgnoreCase("Australia")) {

					System.out.println("Inside Australia Selection");
					sikuClickOnThis("AForAmerica.png", 10, 0.6);
					// scrollDownToEnd(1);
					// sikuClickOnThisWithTargetOffset("Australia.png", -29, 84, 0.7);
					searchForCountryAndClickOnIt("australia");
				}

				else if (countryPerson.equalsIgnoreCase("Italy")) {

					System.out.println("Inside Italy Selection");
					sikuClickOnThis("IForItaly.png", 10, 0.5);
					// sikuClickOnThisWithTargetOffset("Italy.png", -72, 78, 0.6);
					searchForCountryAndClickOnIt("italy");

				} else {

					System.out.println("Inside USA Selection");
					sikuClickOnThis("AForAmerica.png", 10, 0.5);
					scrollDownToEnd(2);
					sikuClickOnThis("USA.png", 10, 0.5);

				}
			}
		} catch (Exception e) {
			System.out.println("Expection in selecting foreign country :" + e);
			e.printStackTrace();
		}
	}

	private static void searchForCountryAndClickOnIt(String countryToSearchFor) throws InterruptedException {

		screen.type("f", KeyModifier.CTRL);
		screen.type(countryToSearchFor);
		if (countryToSearchFor.toLowerCase().contains("usa")) {
			Thread.sleep(700 + randomNumberBetweenMinAndMax(1, 20));
		} else {
			Thread.sleep(400 + randomNumberBetweenMinAndMax(1, 20));
		}
		screen.type(Key.ESC);
		screen.type(Key.ENTER);
		Thread.sleep(10 + randomNumberBetweenMinAndMax(1, 20));

	}
	
	@Test
	public void checkInCheckOutDates() {
		
		        // Define the date and time as strings
		        String checkIndateString = checkInDate;
		        String checkOutdateString = checkOutDate;
		        String timeString = "05:30:00";

		        // Combine date and time strings
		        String checkIndateTimeString = checkIndateString + "T" + timeString;
		        String checkOutdateTimeString = checkOutdateString + "T" + timeString;

		        // Parse the combined date-time string to LocalDateTime
		        LocalDateTime checkinLocalDateTime = LocalDateTime.parse(checkIndateTimeString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		        LocalDateTime checkOutLocalDateTime = LocalDateTime.parse(checkOutdateTimeString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		        
		        // Convert LocalDateTime to milliseconds since epoch
		        ZonedDateTime checkInzonedDateTime = checkinLocalDateTime.atZone(ZoneId.systemDefault());
		        ZonedDateTime checkOutzonedDateTime = checkOutLocalDateTime.atZone(ZoneId.systemDefault());
		        
		        long checkInMilliseconds = checkInzonedDateTime.toInstant().toEpochMilli();
		        long checkOutMilliseconds = checkOutzonedDateTime.toInstant().toEpochMilli();

		        // Output the result
		        System.out.println("CheckIn Date Code for "+checkInDate+" --> " + checkInMilliseconds);
		        System.out.println("CheckOut Date Code for "+checkOutDate+"--> " + checkOutMilliseconds);
	
	}
		

		
	

}
