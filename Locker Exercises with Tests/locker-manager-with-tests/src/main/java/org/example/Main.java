package org.example;
import java.util.Scanner;

public class Main {


    public static void main(String[] arg) {
        Scanner console = new Scanner(System.in);
        LockerManager manager = new LockerManager();


        boolean running = true;


        while (running) {
            System.out.println("\nMenu Options:");
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a locker");
            System.out.println("2. Remove a locker");
            System.out.println("3. Store an item in a locker");
            System.out.println("4. Retrieve an item from a locker");
            System.out.println("5. Display all lockers");
            System.out.println("6. Exit");

            System.out.println("Enter a choice:");
            String choice = console.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Enter locker ID to add: ");
                    String newLockerId = console.nextLine();
                    manager.addLocker(newLockerId);
                    System.out.println("Locker added.");
                    break;
                case "2":
                    System.out.println("Enter a locker ID to remove: ");
                    String removeLocker = console.nextLine();
                    if (removeLocker != null) {
                        manager.removeLocker(removeLocker);
                        System.out.println("Locker removed.");
                    } else {
                        System.out.println("Locker not found. ");
                    }
                    break;
                case "3":
                    System.out.println("Enter your locker ID to access: ");
                    String storeLockerId = console.nextLine();
                    Locker lockerToStore = manager.getLocker(storeLockerId);
                    if (lockerToStore != null) {
                        System.out.println("Enter item to store: ");
                        String item = console.nextLine();
                        lockerToStore.storeItem(item);
                    } else {
                        System.out.println("Locker not found. ");
                    }
                    break;
                case "4":
                    System.out.println("Enter Locker ID to retrieve item from: ");
                    String retrieveLockerId = console.nextLine();
                    Locker toRetrieve = manager.getLocker(retrieveLockerId);
                    if (toRetrieve != null) {
                        toRetrieve.removeItem();
                        System.out.println("Item removed. ");
                    } else {
                        System.out.println("Locker not found.");
                    }
                    break;
                case "5":
                    boolean anyOccupied = false;
                    for (Locker locker : manager.getLockers()) {
                        if (locker.isOccupied()) {
                            anyOccupied = true;

                        }
                    }
                    if (!anyOccupied) {
                        System.out.println("All lockers are empty.");
                    } else {
                        manager.displayAllLockers();
                    }
                    break;
                case "6":
                    System.out.println("Exiting...goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
