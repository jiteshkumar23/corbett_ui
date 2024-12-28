package Extras;

import org.sikuli.script.Screen;

public class ScrollDown {
    public static void main(String[] args) throws InterruptedException {
    	Thread.sleep(2000);
        // Create a Screen object
        Screen screen = new Screen();

        // Scroll down
        scrollDown(screen, 10); // Adjust the scroll amount as needed

        System.out.println("Scrolled down successfully!");
    }

    // Function to perform mouse scroll down
    private static void scrollDown(Screen screen, int scrollAmount) {
        for (int i = 0; i < scrollAmount; i++) {
            screen.wheel(1, 1); // Perform scroll down action
        }
    }
}
