package org.airport;
import org.airport.model.Flight;
import org.airport.model.Passenger;
import org.airport.repository.FlightRepository;
import org.airport.repository.SampleFlightRepository;
import org.airport.service.ReservationData;
import org.airport.service.ReservationService;
import org.airport.util.CsvUtils;
import java.util.List;

public class AppRunner {
    public void run() {

        FlightRepository flightRepo = new SampleFlightRepository();
        List<Flight> flights = flightRepo.getFlights();

        ReservationService reservationService = new ReservationService();

        Passenger p1 = new Passenger("Shannon Young", "A10582");
        Passenger p2 = new Passenger("Zora Young", "D68579");

        reservationService.addPassengerReservation("A775", p1);
        reservationService.addPassengerReservation("H682", p2);

        CsvUtils.saveReservationsToCsv(
                reservationService.getAllReservations(),
                flights
        );

        ReservationData loadedData = CsvUtils.loadReservationsFromCsv();
        System.out.println("Loaded from CsV: " + loadedData.getReservations());

    }
}
