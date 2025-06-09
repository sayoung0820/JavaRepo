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

        LockerService manager = new LockerService(lockerCount);
        boolean running = true;

        while (running) {
            Utilities.displayMenu(manager.hasAvailableLocker());
            String choice = Utilities.getStringInput("Enter your choice: ");

            switch (choice) {
                case "1":
                    if (manager.hasAvailableLocker()) {
                        manager.rentLocker();
                    } else {
                        Utilities.printMessage("No lockers available.");
                    }
                    break;
                case "2":
                    manager.accessLocker();
                    break;
                case "3":
                    manager.releaseLocker();
                    break;
                default:
                    Utilities.printMessage("Goodbye!");
                    running = false;
            }
        }
    }
}