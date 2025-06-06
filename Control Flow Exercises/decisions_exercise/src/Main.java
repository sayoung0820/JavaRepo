import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String pathChoice = "none";
        String fightFlee = "none";
        String treasureChoice = "none";

        // Welcome player and explain scenario
        System.out.println("Welcome to the Underground Cave Game!");
        System.out.println("Your cat Biscuit is trapped in an underground cave!");

        // Starting prompt where player chooses to enter the cave or leave
        System.out.println("Do you want to enter the cave to save him?");
        System.out.println("Enter Yes or No ");
        String enterCave = console.nextLine();

        // A decision inside the cave (choosing between left or right path)
        if (enterCave.equalsIgnoreCase("Yes")) {
            System.out.println("Choose a path: Left or Right");
            pathChoice = console.nextLine();

            // A nested decision on one of the paths (fight or flee from mysterious figure)
            if (pathChoice.equalsIgnoreCase("Left")) {
                System.out.println("Oh no! A fire breathing dragon is blocking this path!");
                System.out.println("Do you want to fight or flee?");
                fightFlee = console.nextLine();

                if (fightFlee.equalsIgnoreCase("fight")) {
                    System.out.println("You bravely defeated the dragon!");
                } else if (fightFlee.equalsIgnoreCase("flee")) {
                    System.out.println("You are almost burned alive by the fire breathing dragon and barely escape " +
                            "with your life!");
                } else {
                    // Invalid action
                    System.out.println("That wasn't a valid action.");
                }
            } else if (pathChoice.equalsIgnoreCase("right")) {
                // A switch statement allowing player to select an artifact with different outcomes
                System.out.println("You find a massive treasure room.");
                System.out.println("Choose one treasure to take.");
                System.out.println("1. Gem");
                System.out.println("2. Key");
                System.out.println("3. Book");
                System.out.println("Enter 1, 2, or 3");
                treasureChoice = console.nextLine();

                switch (treasureChoice) {
                    case "1":
                        System.out.println("The gem will help you defeat more dragons!");
                        break;
                    case "2":
                        System.out.println("The key unlocks the secret tunnel that leads directly to Biscuit!");
                        break;
                    case "3":
                        System.out.println("The book reveals a map of a secret tunnel to escape with Biscuit!");
                        break;
                    default:
                        System.out.println("That wasn't a valid choice.");
                        break;
                }
            } else {
                System.out.println("That's not a valid direction. You are lost in the cave and unable to save Biscuit");
            }
            // If player chooses not to enter cave
        } else if (enterCave.equalsIgnoreCase("No")) {
            System.out.println("You decide not to enter the cave and Biscuit is lost forever.");
            // Invalid input to enter cave
        } else {
            System.out.println("Invalid choice. Try again to save Biscuit!");
        }

        System.out.println("Your journey summary: " + "Entered cave: " + enterCave + ", Went left or right: " + pathChoice +
                ", Fight or Flee: " + fightFlee + ", Treasure choice: " + treasureChoice);
        System.out.println("Thanks for playing, hope you enjoyed!");

    }
}

