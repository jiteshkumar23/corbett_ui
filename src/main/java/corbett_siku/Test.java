package corbett_siku;

import java.io.File;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Image;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;


public class Test {
	
	public static Screen screen = new Screen(); ;
	static String imagePath = System.getProperty("user.dir") + File.separator + "images" + File.separator ;
	
	public static void main(String[] args) throws FindFailed, InterruptedException {
		
		System.out.println("Hi");
		sikuClickOnThisAndEnterText("1713619207746.png","Jitesh Kumar");
		sikuClickOnThis("1713619769917.png");
		sikuClickOnThis("1713617792010.png");
		sikuClickOnThisWithTargetOffset("1713621744133.png",208,16);
		sikuClickOnThisWithTargetOffset("1713622089703.png",-90,0);
		sikuClickOnThisWithTargetOffset("1713621949866.png",413,16);
		
		screen.type("986756784598");
		sikuClickOnThisWithTargetOffset("1713622307591.png",508,17);
		screen.type("23");
		
		
		
	}
	
	public static void sikuClickOnThis(String specificImagePath) throws FindFailed {

		//System.out.println(imagePath);
		Pattern imagePattern = new Pattern(imagePath + specificImagePath).similar(0.95);
		screen.wait(imagePath + specificImagePath, 5);
		screen.click(imagePattern);

	}
	
	public static void sikuClickOnThisAndEnterText(String specificImagePath, String text) throws FindFailed, InterruptedException {
//		System.out.println(imagePath);
//		System.out.println(specificImagePath);
//		String fullPath = imagePath +specificImagePath;
//		System.out.println(fullPath);
		Pattern imagePattern = new Pattern(imagePath + specificImagePath).similar(0.95);
		screen.wait(imagePath + specificImagePath, 20);
		screen.click(imagePattern);
		
		int wait = 2000;
		String[] str = text.split("");
		int dividedWait = wait/str.length ;
		for (String str1: str) {
		screen.type(str1);
		Thread.sleep(dividedWait);
		}
	}
	
	public static void sikuClickOnThisWithTargetOffset(String specificImagePath, int targetX, int targetY) throws FindFailed {
		
		String fullImagePath = imagePath + specificImagePath;
		Pattern targetImagePattern = new Pattern(fullImagePath).targetOffset(targetX, targetY).similar(0.5);
		 
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

}
