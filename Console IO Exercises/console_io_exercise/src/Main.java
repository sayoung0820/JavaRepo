import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("Welcome to the order form! ");

        System.out.println("What is your name? ");
        String name = console.nextLine();

        System.out.println(                          );

        System.out.println("Hello, " + name + "!" + " " + "Let's get started with your order.");

        System.out.println(                          );

        System.out.print("What product would you like to purchase? ");
        String product = console.nextLine();

        System.out.println(                          );

        System.out.print("How many would you like? ");
        String quantityStr = console.nextLine();
        int quantity = Integer.parseInt(quantityStr);

        System.out.println(                          );

        System.out.print("What is the unit price? ");
        String costStr = console.nextLine();
        double cost = Double.parseDouble(costStr);

        System.out.println(                          );

        System.out.println("Order Summary");
        System.out.println("------------------------------");

        System.out.println("Item:            " + product);
        System.out.println("Quantity:        " + quantity);
        System.out.println("Unit price:      " + "$" + cost);

        System.out.println("------------------------------");
        System.out.printf("Subtotal:        $%.2f\n", (quantity * cost));
        System.out.printf("Tax:             $%.2f\n", ((quantity * cost) * 0.07));
        System.out.printf("Grand Total:     $%.2f\n", ((quantity * cost) + (quantity * cost) * 0.07));

        System.out.println("-----------------------------------");

        System.out.print("Thank you for your order, " + name + "!");

    }

}

// I know this is WAY more code than necessary, but I couldn't figure out a way to condense it!
