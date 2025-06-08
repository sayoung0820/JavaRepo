import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = "";

        String[] cities = {"Atlanta", "Charlotte", "NYC", "Miami", "Los Angeles"};
        System.out.println(cities[0]);
        System.out.println(cities[1]);
        System.out.println(cities[2]);
        System.out.println(cities[3]);
        System.out.println(cities[4]);

        for (int i = 0; i < cities.length; i++) {
//            System.out.println(cities[i]);

            cities[2] = cities[2].replace("NYC", "Houston");
            System.out.println(cities[i]);
        }
        System.out.println(cities.length);

        for (int i = cities.length - 1; i >= 0; i--) {
            System.out.println(cities[i]);
        }

        System.out.println("Please enter a city name");
        input = console.nextLine();
        if (input.equalsIgnoreCase(cities[0]) ||
                input.equalsIgnoreCase(cities[1]) ||
                input.equalsIgnoreCase(cities[2]) ||
                input.equalsIgnoreCase(cities[3]) ||
                input.equalsIgnoreCase(cities[4])) {

            System.out.println("City found!");
        } else {
            System.out.println("City not found!");
        }

        double[] testScores = {60.0, 75.4, 80.3, 90.4, 100.0};
        double sum = 0.0;
//        for (int i = 0; i < testScores.length; i++) {
//            sum += testScores[i];
//        }
//        System.out.println(sum);
//
//        double highest = testScores[0];
//        double lowest = testScores[0];
//        for (int i = 0; i < testScores.length; i++) {
//            if (testScores[i] > highest) {
//                highest = testScores[i];  // Found a new highest
//            }
//                if (testScores[i] < lowest) {
//                    lowest = testScores[i];   // Found a new lowest
//
//                }
//            }
//            System.out.println("Highest score: " + highest);
//            System.out.println("Lowest score: " + lowest);


        for (int i = 0; i < testScores.length; i++) {
            sum += testScores[i];
        }
        System.out.println(sum / testScores.length);


        }
    }
