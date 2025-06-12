// Utilities.java
// Handles input, output, and utility functions

import java.util.Random;
import java.util.Scanner;

public class Utilities {
    private static final Scanner scanner = new Scanner(System.in);

    public static void printWelcome() {
        System.out.println("Welcome to Lockdown Inc.'s Locker Access System!");
    }

    public static int readInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    public static int getIntInput(String prompt) {
        System.out.print(prompt);
        return readInt();
    }

    public static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static void displayMenu(boolean canRent) {
        System.out.println("\nMain Menu:");
        if (canRent) {
            System.out.println("1. Rent a Locker");
        }
        System.out.println("2. Access a Locker");
        System.out.println("3. Release a Locker");
        System.out.println("Q to Exit");
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static String generatePin() {
        Random rand = new Random();
        int number = rand.nextInt(10000);
        return String.format("%04d", number); // ensures 4 digits with leading zeros
    }
}

