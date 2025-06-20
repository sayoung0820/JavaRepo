import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        ApplianceStates[] appliances = new ApplianceStates[5];
        appliances[0] = new TV();
        appliances[1] = new Toaster();
        appliances[2] = new Radio();
        appliances[3] = new Laptop();
        appliances[4] = new Fridge();

        boolean running = true;
        while (running) {
            System.out.println("Choose an appliance to manage: ");
            System.out.println("1. TV");
            System.out.println("2. Fridge");
            System.out.println("3. Toaster");
            System.out.println("4. Laptop");
            System.out.println("5. Radio");
            System.out.println("6. Quit");
            System.out.print("Enter your choice (1-6): ");
            int choice = console.nextInt();
            console.nextLine();

            switch (choice) {
                case 1:

            }

        }
    }
}
