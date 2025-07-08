package org.airport.service;
import org.airport.model.*;
import org.airport.model.Passenger;
import java.util.List;
import java.util.Map;

public class ReservationData {
    private Map<String, List<Passenger>> reservations;
    private List<Flight> flights;

    public ReservationData(Map<String, List<Passenger>> reservations, List<Flight> flights) {
        this.reservations = reservations;
        this.flights = flights;
    }

    public Map<String, List<Passenger>> getReservations() {
        return reservations;
    }

    public List<Flight> getFlights() {
        return flights;
    }
}
