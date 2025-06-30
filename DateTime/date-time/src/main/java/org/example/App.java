package org.example;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class App {
    public static void main(String[] args) {

        LocalTime current = LocalTime.now(); // System time, time of the server, not your actual location most times
        LocalTime noon = LocalTime.of(12, 15, 35);
        // Can also do this way
        int hour = 12;
        int minute = 15;
        int second = 35;
        LocalTime noon2 = LocalTime.of(hour, minute, second);
        System.out.println(noon);
        System.out.println(noon2);

        LocalTime parsed = LocalTime.parse("12:15:35");
    }
}
