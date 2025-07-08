package org.airport.service;
import org.airport.model.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservationService {
    private final Map<String, List<Passenger>> reservations = new HashMap<>();

    public void addPassengerReservation(String flightNumber, Passenger passenger) {
        List<Passenger> passengerList = reservations.computeIfAbsent(flightNumber, k -> new ArrayList<>());
        passengerList.add(passenger);
    }

    public List<Passenger> getAllPassengersOnFlight(String flightNumber) {
        return reservations.getOrDefault(flightNumber, new ArrayList<>());
    }

    public Map<String, List<Passenger>> getAllReservations() {
        return reservations;
    }
}
