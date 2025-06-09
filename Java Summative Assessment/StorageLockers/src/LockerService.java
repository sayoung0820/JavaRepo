// LockerService.java
// Handles renting, accessing, and releasing lockers


public class LockerService {
    private Locker[] lockers;
    private Results results;

    public LockerService(int size) {
        lockers = new Locker[size];
        for (int i = 0; i < size; i++) {
            lockers[i] = new Locker(i + 1, null); // initialize lockers
        }
        results = new Results();
    }

    public boolean isFull() {
        for (Locker locker : lockers) {
            if (locker.isAvailable()) {
                return false;
            }
        }
        return true;
    }

    public void rentLocker() {
        for (Locker locker : lockers) {
            if (locker.isAvailable()) {
                String pin = Utilities.generatePin();
                locker.assignPin(pin);
                Utilities.printMessage("Locker #" + locker.getLockerNumber() + " rented with PIN: " + pin);
                return;
            }
        }

//        Utilities.printMessage("Sorry, no lockers available to rent.");
    }

    public void accessLocker() {
        int lockerNumber = Utilities.getIntInput("Enter locker number: ");
        String pin = Utilities.getStringInput("Enter PIN: ");

        if (lockerNumber < 1 || lockerNumber > lockers.length) {
            Utilities.printMessage("Invalid locker number.");
            return;
        }

        Locker locker = lockers[lockerNumber - 1];
        if (!locker.isAvailable() && locker.getPin().equals(pin)) {
            Utilities.printMessage("Access granted to locker #" + lockerNumber);
        } else {
            Utilities.printMessage("Access denied. Incorrect PIN or locker is empty.");
        }
    }

    public void releaseLocker() {
        int lockerNumber = Utilities.getIntInput("Enter locker number: ");
        String pin = Utilities.getStringInput("Enter PIN: ");

        if (lockerNumber < 1 || lockerNumber > lockers.length) {
            Utilities.printMessage("Invalid locker number.");
            return;
        }

        Locker locker = lockers[lockerNumber - 1];
        if (!locker.isAvailable() && locker.getPin().equals(pin)) {
            String confirm = Utilities.getStringInput("Are you sure you want to release locker #" + lockerNumber + "? (Yes/No): ");
            if (confirm.equalsIgnoreCase("Yes")) {
                locker.clearLocker();
                Utilities.printMessage("Locker #" + lockerNumber + " has been released.");
            } else {
                Utilities.printMessage("Locker release canceled.");
            }
        } else {
            Utilities.printMessage("Error: Incorrect PIN or locker is already available.");
        }
    }

    public boolean hasAvailableLocker() {
        for (Locker locker : lockers) {
            if (locker.isAvailable()) {
                return true;
            }
        }
        return false;
    }
}