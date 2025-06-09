// Locker.java
// Represents a single locker and its assigned PIN

public class Locker {
    private int lockerNumber;
    private String pin;

    public Locker(int lockerNumber, String pin) {
        this.lockerNumber = lockerNumber;
        this.pin = pin;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public String getPin() {
        return pin;
    }

    public void clearLocker() {
        this.pin = null;
    }

    public boolean isAvailable() {
        return pin == null;
    }

    public void assignPin(String pin) {
        this.pin = pin;
    }
}