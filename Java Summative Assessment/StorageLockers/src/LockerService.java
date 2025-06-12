// LockerService.java
// Handles renting, accessing, and releasing lockers


public class LockerService {
    private final Locker[] lockers;

    public LockerService(int size) {
        lockers = new Locker[size];
        for (int i = 0; i < size; i++) {
            lockers[i] = new Locker(i + 1, null); // initialize lockers
        }
    }

    public Results rentLocker() {
        for (Locker locker : lockers) {
            if (locker.isAvailable()) {
                String pin = Utilities.generatePin();
                locker.assignPin(pin);
                return new Results(true, "Locker #" + locker.getLockerNumber() + " rented with PIN: " + pin);
            }
        }
        return new Results(false, "Sorry, no lockers available to rent.");
    }

    public Results accessLocker() {
        int lockerNumber = Utilities.getIntInput("Enter locker number: ");
        String pin = Utilities.getStringInput("Enter PIN: ");

        if (lockerNumber < 1 || lockerNumber > lockers.length) {
            return new Results(false, "Invalid locker number.");
        }

        Locker locker = lockers[lockerNumber - 1];
        if (!locker.isAvailable() && locker.getPin().equals(pin)) {
            return new Results(true, "Access granted to locker #" + lockerNumber);
        } else {
            return new Results(false, "Access denied. Incorrect PIN or locker is empty.");
        }
    }

    public Results releaseLocker() {
        int lockerNumber = Utilities.getIntInput("Enter locker number: ");
        String pin = Utilities.getStringInput("Enter PIN: ");

        if (lockerNumber < 1 || lockerNumber > lockers.length) {
            return new Results(false, "Invalid locker number.");
        }

        Locker locker = lockers[lockerNumber - 1];
        if (!locker.isAvailable() && locker.getPin().equals(pin)) {
            String confirm = Utilities.getStringInput("Are you sure you want to release locker #" + lockerNumber + "? (Yes/No): ");
            if (confirm.equalsIgnoreCase("Yes")) {
                locker.clearLocker();
                return new Results(true, "Locker #" + lockerNumber + " has been released.");
            } else {
                return new Results(false, "Locker release cancelled.");
            }
        } else {
            return new Results(false, "Error: Incorrect PIN or locker is already available.");
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