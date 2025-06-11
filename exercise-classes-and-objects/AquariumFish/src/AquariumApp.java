// Original Starter Code in a single file
// Refactor this code - move local variables to an object
// Completed the exercise then added an array, for loop,

import java.util.Scanner;

public class AquariumApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the fish: ");
        String fishName = scanner.nextLine();

        System.out.print("Enter the minimum temperature the fish can tolerate: ");
        double minTemp = scanner.nextDouble();

        System.out.print("Enter the maximum temperature the fish can tolerate: ");
        double maxTemp = scanner.nextDouble();

        double averageTemp = (minTemp + maxTemp) / 2.0;

        System.out.println("\n--- Fish Summary ---");
        System.out.println("Fish Name: " + fishName);
        System.out.println("Minimum Temperature: " + minTemp + "°C");
        System.out.println("Maximum Temperature: " + maxTemp + "°C");
        System.out.println("Average Optimal Temperature: " + averageTemp + "°C");

        scanner.close();
    }
}
