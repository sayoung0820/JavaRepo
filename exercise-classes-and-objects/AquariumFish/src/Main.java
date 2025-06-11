import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("How many fish would you like to enter?");
        int fishCount = console.nextInt();
        console.nextLine();

        // declaring an array of fish
        AquariumFish[] fishArray = new AquariumFish[fishCount];

        for (int i = 0; i < fishCount; i++) {

            System.out.println("Please enter fish name: ");
            String name = console.nextLine();

            System.out.println("Enter the minimum temperature the fish can tolerate: ");
            double minTemp = console.nextDouble();
            console.nextLine();

            System.out.println("Enter the maximum temperature the fish can tolerate: ");
            double maxTemp = console.nextDouble();
            console.nextLine();
            AquariumFish fish = new AquariumFish(name, minTemp, maxTemp);
            fishArray[i] = fish;
        }


        System.out.println("\nSummary of all fish entered:");
        for (int i = 0; i < fishArray.length; i++) {
            AquariumFish currentFish = fishArray[i];
            double avg = currentFish.calculateAverageTemp();

            System.out.println("Fish " + (i + 1) + ": " + currentFish.getName());
            System.out.println("  - Minimum Temp: " + currentFish.getMinTemp());
            System.out.println("  - Maximum Temp: " + currentFish.getMinTemp());
            System.out.println("  - Maximum Temp: " + currentFish.getMaxTemp());
            System.out.println("  - Average Temp: " + avg);

        }

//            AquariumFish fish = new AquariumFish(name, minTemp, maxTemp);
//            double average = fish.calculateAverageTemp();
//            System.out.println("The average temperature for " + fish.getName() + " is " + average + " degrees.");


//        System.out.println("Please enter fish name: ");
//        String name = console.nextLine();
//
//        System.out.println("Enter the minimum temperature the fish can tolerate: ");
//        double minTemp = console.nextDouble();
//
//        System.out.println("Enter the maximum temperature the fish can tolerate: ");
//        double maxTemp = console.nextDouble();
//
//        AquariumFish fish = new AquariumFish(name, minTemp, maxTemp);
//
//        double average = fish.calculateAverageTemp();
//        System.out.println("The average temperature for " + fish.getName() + " is " + average + " degrees.");


        }
    }
