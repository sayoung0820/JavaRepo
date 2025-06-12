// Main.java
// App flow and user interaction

public class Main {
    public static void main(String[] args) {
        Utilities.printWelcome();
        int lockerCount = Utilities.getIntInput("How many lockers are available today? ");

        while (lockerCount <= 0) {
            Utilities.printMessage("Please enter a number greater than 0.");
            lockerCount = Utilities.getIntInput("How many lockers are available today? ");
        }
        Utilities.printMessage("\nThere are " + lockerCount + " lockers available today.");

        LockerService manager = new LockerService(lockerCount);
        boolean running = true;
        Results result = null;

        while (running) {
            Utilities.displayMenu(manager.hasAvailableLocker());
            String choice = Utilities.getStringInput("Please enter your choice: ");

            switch (choice) {
                case "1":
                    if (manager.hasAvailableLocker()) {
                       result = manager.rentLocker();
                       Utilities.printMessage(result.getMessage());
                    }
                    break;
                case "2":
                    result = manager.accessLocker();
                    Utilities.printMessage(result.getMessage());
                    break;
                case "3":
                    result = manager.releaseLocker();
                    Utilities.printMessage(result.getMessage());
                    break;
                case "q":
                    Utilities.printMessage("Thanks for using the app. Goodbye!");
                    running = false;
                    break;
                default:
                    Utilities.printMessage("Invalid choice. Please try again.");
            }
        }
    }
}