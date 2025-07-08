package org.airport.model;

public class CommercialAircraft extends Aircraft {
    private final String airlineName;


    public CommercialAircraft(String model, int capacity, double fuelCapacity, String airlineName) {
        super(model, capacity, fuelCapacity);
        this.airlineName = airlineName;
    }


    public String getAirlineName() {
        return airlineName;
    }

    @Override
    public String toString() {
        return "CommercialAircraft{" +
                "model='" + getModel() + '\'' +
                ", capacity=" + getCapacity() +
                ", fuelCapacity=" + getFuelCapacity() +
                ", airlineName=" + getAirlineName();
    }
}
