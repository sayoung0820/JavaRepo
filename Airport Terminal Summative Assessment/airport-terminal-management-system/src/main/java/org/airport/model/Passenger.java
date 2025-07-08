package org.airport.model;

public class Passenger {
    private final String name;
    private final String passportNumber;

    public Passenger(String name, String passportNumber) {
        this.name = name;
        this.passportNumber = passportNumber;
    }

    public String getName() {
        return name;
    }

     public String getPassportNumber() {
        return passportNumber;
    }

    @Override
    public  String toString() {
        return "Passenger{name = '" + name + "', Passport Number = '" + passportNumber + "'}";
    }

}
