package org.example;

public class Locker {
    private final String lockerId;
    private boolean isOccupied;
    private String contents;

    public Locker(String lockerId) {
        this.lockerId = lockerId;
        this.isOccupied = false;
        this.contents = "";
    }

    public void storeItem(String item) {
        this.contents = item;
        this.isOccupied = true;
    }

    public void removeItem() {
        this.contents = "";
        this.isOccupied = false;
    }

    public String getLockerId() {
        return lockerId;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public String toString() {
        return "Locker ID: " + lockerId  + "\nOccupied: " + isOccupied + "\nContents: " +  contents;
    }

}
