package Extras;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Typing {

	public static void main(String[] args) {

	}

	public void typeTextWithRobot(String text) throws InterruptedException {
		try {
			// Create Robot instance within the method
			new Robot() {
				{

					for (char c : text.toCharArray()) {
						int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
						if (KeyEvent.CHAR_UNDEFINED == keyCode) {
							throw new RuntimeException("Key code not found for character '" + c + "'");
						}
						keyPress(keyCode);
						Thread.sleep(randomNumberBetweenMinAndMax(10, 30));
						keyRelease(keyCode);
						Thread.sleep(randomNumberBetweenMinAndMax(60, 100));
					}
				}
			};

		} catch (AWTException e) {
			e.printStackTrace();
		}

	}

	public int randomNumberBetweenMinAndMax(int min, int max) {
		// Create an instance of the Random1 class
		Random rand = new Random();

		// Generate a random number between 10 and 50
		int randomNumber = rand.nextInt(max - min + 1) + min; // The range is [0, 41), so we add 10 to shift it to [10,
																// 50]

		// Print the random number
		// System.out.println("Random number between "+min+" and "+max+": " +
		// randomNumber);
		return randomNumber;

	}

	public static void pressEnterKey() {
		try {
			// Create Robot instance within the method
			new Robot() {
				{
					keyPress(KeyEvent.VK_ENTER);
					keyRelease(KeyEvent.VK_ENTER);
					delay(10); // Small delay of 10 milliseconds
				}
			};

		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

}
