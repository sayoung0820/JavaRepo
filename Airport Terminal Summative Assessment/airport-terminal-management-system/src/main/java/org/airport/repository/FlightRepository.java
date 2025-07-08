package org.airport.repository;
import org.airport.model.Flight;
import java.util.List;

public interface FlightRepository {
    List<Flight> getFlights();
}
