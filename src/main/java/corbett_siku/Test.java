package corbett_siku;

import java.io.File;
import java.util.Random;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Mouse;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;


public class Test {
	
	public static Screen screen = new Screen(); 
	
	
	static String imagePath = System.getProperty("user.dir") + File.separator + "images" + File.separator ;
	
	public static void main(String[] args) throws FindFailed, InterruptedException {
		
		
		sikuClickOnThisAndEnterText("firstNameBox.png","Jitesh Kumar", 0);
		//randomMouseMovement();
		sikuClickOnThis("firstGenderDropdown.png");
		sikuClickOnThis("female.png");
		sikuClickOnThisWithTargetOffset("firstIDTypeDropdown.png",208,16, 0.45);
		sikuClickOnThisWithTargetOffset("AadhaarInIDDropdown.png",-90,0, 0.45);
		sikuClickOnThisWithTargetOffset("firstIDNumberDropDown.png",413,16, 0.45);
		
		screen.type("986756784511");
		sikuClickOnThisWithTargetOffset("firstAgeBox.png",508,17, 0.45);
		screen.type("21");
		
		
		sikuClickOnThisAndEnterText("secondNameBox.png","Nitesh Kumar", 0);
		sikuClickOnThisWithTargetOffset("secondGenderDropdown.png",156,17, 0.45);
		sikuClickOnThis("female.png");
		sikuClickOnThisWithTargetOffset("secondIDTypeDropdown",261,22, 0.45);
		sikuClickOnThisWithTargetOffset("AadhaarInIDDropdown.png",-90,0 ,0.45);
		sikuClickOnThisWithTargetOffset("secondIDNumberDropDown.png",416,22,0.95);
		screen.type("986756784522");
		sikuClickOnThisWithTargetOffset("secondAgeBox.png",508,0, 0.45);
		screen.type("22");
		
		
//		sikuClickOnThisAndEnterText("thirdNameBox.png","Nitesh3 Kumar", 0);
//		sikuClickOnThisAndEnterText("fourNameBox.png","Nitesh4 Kumar", 0);
//		sikuClickOnThisAndEnterText("fiveNameBox.png","Nitesh5 Kumar", 0);
//		sikuClickOnThisAndEnterText("sixNameBox.png","Nitesh6 Kumar", 0);
		
		
		
		
		


//		sikuClickOnThisWithTargetOffset("secondIDNumberDropDown.png",460,0);
//		screen.type("986756784522");
//		sikuClickOnThisWithTargetOffset("secondAgeBox.png",509,0);
//		screen.type("33");
		
	}
	
	public static void sikuClickOnThis(String specificImagePath) throws FindFailed {

		//System.out.println(imagePath);
		Pattern imagePattern = new Pattern(imagePath + specificImagePath).similar(0.4);
		screen.wait(imagePath + specificImagePath, 5);
		screen.click(imagePattern);

	}
	

	public static void sikuClickOnThisAndEnterText(String specificImagePath, String text , int timeToType) throws FindFailed, InterruptedException {
//		System.out.println(imagePath);
//		System.out.println(specificImagePath);
//		String fullPath = imagePath +specificImagePath;
//		System.out.println(fullPath);
		Pattern imagePattern = new Pattern(imagePath + specificImagePath).similar(0.4);
		screen.wait(imagePath + specificImagePath, 20);
		screen.click(imagePattern);
		
		String[] str = text.split("");
		int dividedWait = timeToType/str.length ;
		for (String str1: str) {
		screen.type(str1);
        int randomNumber = randomNumberBetweenMinAndMax(dividedWait, dividedWait+15);
		Thread.sleep(randomNumber);
		}
	}
	
	public static void sikuClickOnThisWithTargetOffset(String specificImagePath, int targetX, int targetY , double offset) throws FindFailed {
		
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
	
	 public static int randomNumberBetweenMinAndMax(int min , int max) {
		 // Create an instance of the Random1 class
	        Random rand = new Random();

	        // Generate a random number between 10 and 50
	        int randomNumber = rand.nextInt(max - min + 1) + min;  // The range is [0, 41), so we add 10 to shift it to [10, 50]

	        // Print the random number
	       // System.out.println("Random number between "+min+" and "+max+": " + randomNumber);
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

         // Wait for a moment to see the movement
         Thread.sleep(200); 
		 
	 }
	 

}
