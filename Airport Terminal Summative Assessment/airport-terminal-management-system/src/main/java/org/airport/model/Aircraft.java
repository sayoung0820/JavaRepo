package org.airport.model;

public abstract class Aircraft {
    private final String model;
    private final int capacity;
    private final double fuelCapacity;

    public Aircraft(String model, int capacity, double fuelCapacity) {
        this.model = model;
        this.capacity = capacity;
        this.fuelCapacity = fuelCapacity;
    }

    public String getModel() {
        return model;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "model='" + model + '\'' +
                ", capacity=" + capacity +
                ", fuelCapacity=" + fuelCapacity +
                '}';
    }
}
