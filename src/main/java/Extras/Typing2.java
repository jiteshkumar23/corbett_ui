package Extras;

import com.tulskiy.keymaster.common.HotKey;
import com.tulskiy.keymaster.common.HotKeyListener;
import com.tulskiy.keymaster.common.Provider;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Typing2 {

    private static Provider provider;
    private static boolean hotkeyPressed = false;  // Flag to check if hotkey is pressed

    public static void main(String[] args) {
        // Initialize the provider once
        provider = Provider.getCurrentProvider(false);

        // Register hotkey for the entire program
        registerHotkey();

        // Call methods which wait for hotkey press before executing
        method1("Jack");
        System.out.println("Hello");
        method2();
        method3();
        method4();
        method5();

        // Keep the program running indefinitely
        System.out.println("Press Alt+Q to execute the methods.");
    }

    private static void registerHotkey() {
        // Register Alt+Q hotkey to trigger execution of methods
        provider.register(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.ALT_DOWN_MASK), new HotKeyListener() {
            @Override
            public void onHotKey(HotKey hotKey) {
                // Set the flag to true when hotkey is pressed
                hotkeyPressed = true;
                System.out.println("Hot key pressed !");
            }
        });
    }

    // Method 1 that takes a parameter and waits for hotkey press before executing
    public static void method1(String param) {
        waitForHotkey();
        System.out.println("Executing Method 1 with parameter: " + param);
    }

    // Other methods that wait for hotkey press before executing
    public static void method2() {
        waitForHotkey();
        System.out.println("Executing Method 2");
    }

    public static void method3() {
        waitForHotkey();
        System.out.println("Executing Method 3");
    }

    public static void method4() {
        waitForHotkey();
        System.out.println("Executing Method 4");
    }

    public static void method5() {
        waitForHotkey();
        System.out.println("Executing Method 5");
    }

    // Method to wait for hotkey press before continuing method execution
    public static void waitForHotkey() {
        // Block until Alt+Q is pressed
        while (!hotkeyPressed) {
            // You can add a small delay here to avoid 100% CPU usage while waiting
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        // Reset the hotkey press flag after it has been handled
        hotkeyPressed = false;
    }
}
