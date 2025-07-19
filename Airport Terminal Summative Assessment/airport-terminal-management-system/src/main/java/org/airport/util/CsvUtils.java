package org.airport.util;
import org.airport.model.*;
import org.airport.service.ReservationData;
import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvUtils {

    private static final String FILE_NAME = "reservations.csv";
    private static final String DATA_FOLDER = "data/";
    private static final String FILE_PATH = DATA_FOLDER + FILE_NAME;

    public static void saveReservationsToCsv(
            Map<String, List<Passenger>> reservations, List<Flight> flights) {
        new File(DATA_FOLDER).mkdirs();

        File file = new File(FILE_PATH);
        boolean isFileEmpty = !file.exists() || file.length() == 0;

        try (FileWriter writer = new FileWriter(file, true)) {

            if (isFileEmpty) {
                writer.write("flightNumber, departureDate, ticketPrice, passengerName, passportNumber, aircraftModel,aircraftType\n");

            }
            for (Flight flight : flights) {
                String flightNumber = flight.getFlightNumber();
                List<Passenger> passengerList = reservations.get(flightNumber);

                if (passengerList != null && !passengerList.isEmpty()) {
                    for (Passenger passenger : passengerList) {
                        String line = String.join(",",
                                flight.getFlightNumber(),
                                flight.getDepartureDate().toString(),
                                flight.getTicketPrice().toString(),
                                passenger.getName(),
                                passenger.getPassportNumber(),
                                flight.getAircraft().getModel(),
                                flight.getAircraft().getClass().getSimpleName());

                        writer.write(line + "\n");
                    }
                }
            }
            System.out.println("Reservations saved to " + "resources\\" + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error saving reservations.csv: " + e.getMessage());
        }
    }

    public static ReservationData loadReservationsFromCsv() {
        Map<String, List<Passenger>> reservations = new HashMap<>();
        List<Flight> flights = new ArrayList<>();

        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("File not found: " + FILE_PATH);
            return new ReservationData(reservations, flights);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

                if (values.length != 7) {
                    System.out.println("Malform line skipped: " + line);
                    continue;
                }

                String flightNumber = values[0];
                LocalDate departureDate = LocalDate.parse(values[1]);
                BigDecimal ticketPrice = new BigDecimal(values[2]);
                String passengerName = values[3];
                String passportNumber = values[4];
                String aircraftModel = values[5];
                String aircraftType = values[6];

                Aircraft aircraft;
                if (aircraftType.equals("CommercialAircraft")) {
                    aircraft = new CommercialAircraft(aircraftModel, 180, 30000, "unknown");
                } else {
                    aircraft = new PrivateJet(aircraftModel, 9, 25000, false, 900);
                }

                Flight flight = new Flight(flightNumber, departureDate, ticketPrice, aircraft);
                if (!flights.contains(flight)) {
                    flights.add(flight);
                }

                if (!passengerName.equalsIgnoreCase("None")) {
                    Passenger passenger = new Passenger(passengerName, passportNumber);
                    reservations.computeIfAbsent(flightNumber, k -> new ArrayList<>()).add(passenger);
                }
            }

            System.out.println("Reservations loaded from " + FILE_PATH);
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        return new ReservationData(reservations, flights);
    }
}


