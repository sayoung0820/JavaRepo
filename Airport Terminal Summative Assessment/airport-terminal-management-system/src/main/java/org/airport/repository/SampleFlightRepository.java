package org.airport.repository;
import org.airport.model.CommercialAircraft;
import org.airport.model.Flight;
import org.airport.model.PrivateJet;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SampleFlightRepository implements FlightRepository{

    @Override
    public List<Flight> getFlights() {
        List<Flight> flights = new ArrayList<>();

        flights.add(new Flight("A775",
                LocalDate.of(2025, 8, 30),
                new BigDecimal("300.00"),
                new CommercialAircraft("Boeing 737", 200, 30000, "American Airlines")));

        flights.add(new Flight("H682",
                LocalDate.of(2025, 9, 15),
                new BigDecimal("700.00"),
                new PrivateJet("HondaJet Elite", 7,  400, false, 422)));

        return flights;
    }
}
