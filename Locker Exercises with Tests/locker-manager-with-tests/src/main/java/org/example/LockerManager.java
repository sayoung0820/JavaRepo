package org.example;
import java.util.ArrayList;

public class LockerManager {
    private ArrayList<Locker> lockers;

    public LockerManager() {
        lockers = new ArrayList<>();
    }

    public ArrayList<Locker> getLockers() {
        return lockers;
    }

    public void setLockers(ArrayList<Locker> lockers) {
        this.lockers = lockers;
    }

    public void addLocker(String lockerId) {
        Locker newLocker = new Locker(lockerId);
        lockers.add(newLocker);
    }

    public Locker getLocker(String lockerId) {
        for (int i = 0; i < lockers.size(); i++) {
            Locker currentLocker = lockers.get(i);
            if (currentLocker.getLockerId().equals(lockerId)) {
                return currentLocker;
            }
        }
        return null;
    }

    public void removeLocker(String lockerId) {
        for (int i = 0; i < lockers.size(); i++) {
            Locker currentLocker = lockers.get(i);
            if (currentLocker.getLockerId().equals(lockerId)) {
                lockers.remove(i);
                break;
            }
        }
    }

    public void displayAllLockers() {
        for (int i = 0; i < lockers.size(); i++) {
            Locker currentLocker = lockers.get(i);
            System.out.println(currentLocker);
        }
    }

}