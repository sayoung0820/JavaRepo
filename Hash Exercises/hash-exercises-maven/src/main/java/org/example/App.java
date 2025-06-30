package org.example;
//import java.awt.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
//        Map<Integer, String> monthMap = new HashMap<>();
//
//        monthMap.put(1, "January");
//        monthMap.put(2, "February");
//        monthMap.put(3, "March");
//        monthMap.put(4, "April");
//        monthMap.put(5, "May");
//        monthMap.put(6, "June");
//        monthMap.put(7, "July");
//        monthMap.put(8, "August");
//        monthMap.put(9, "September");
//        monthMap.put(10, "October");
//        monthMap.put(11, "November");
//        monthMap.put(12, "December");

//        String monthName = monthMap.get(1);
//        System.out.println(monthName);
//
//        for (Integer key : monthMap.keySet()) {
//            System.out.println("Month #" + key + " is " + monthMap.get(key));
//        }

        Map<String, List<String>> cardDeck = new HashMap<>();

        List<String> cards = Arrays.asList(
                "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"
        );

        cardDeck.put("Hearts", new ArrayList<>(cards));
        cardDeck.put("Spades", new ArrayList<>(cards));
        cardDeck.put("Diamonds", new ArrayList<>(cards));
        cardDeck.put("Clubs", new ArrayList<>(cards));

        for (String suit : cardDeck.keySet()) {
            for (String card : cardDeck.get(suit)) {
                System.out.println(card + " of " + suit);
            }
        }




    }
}