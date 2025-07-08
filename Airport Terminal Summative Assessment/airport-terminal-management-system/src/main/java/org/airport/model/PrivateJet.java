package org.airport.model;

public class PrivateJet extends Aircraft{
    private final boolean hasLuxuryService;
    private final int maxSpeed;


    public PrivateJet(String model, int capacity, double fuelCapacity, boolean hasLuxuryService, int maxSpeed) {
        super(model, capacity, fuelCapacity);
        this.hasLuxuryService = hasLuxuryService;
        this.maxSpeed = maxSpeed;
    }

    public boolean hasLuxuryService() {
        return hasLuxuryService;
    }

    public int getMaxSpeed() {
        return maxSpeed ;
    }

    @Override
    public String toString() {
        return "PrivateJet{" +
                "model='" + getModel() + '\'' +
                ", capacity=" + getCapacity() +
                ", fuelCapacity=" + getFuelCapacity() +
                "hasLuxuryService=" + hasLuxuryService +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
