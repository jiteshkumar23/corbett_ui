package corbett_siku;

import java.util.Random;


public class Random1 {
	
	public static void main(String[] args) {
		
		 // Create an instance of the Random1 class
        Random rand = new Random();

        // Generate a random number between 10 and 50
        int randomNumber = rand.nextInt(41) + 10;  // The range is [0, 41), so we add 10 to shift it to [10, 50]

        // Print the random number
        System.out.println("Random1 number between 10 and 50: " + randomNumber);

}
}
