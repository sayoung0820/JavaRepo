package org.shoppinginc.commands;
import org.shoppinginc.services.CartService;
import org.shoppinginc.services.InventoryService;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuRunner {
    private final Scanner console;
    private final Map<String, CommandManager> commands = new HashMap<>();

    public MenuRunner(CartService cartService, InventoryService inventoryService) {
        this.console = new Scanner(System.in);

        commands.put("1", new DisplayCartCommand(inventoryService, cartService, console));
        commands.put("2", new AddItemCommand(inventoryService, cartService, console));
        commands.put("3", new RemoveItemCommand(inventoryService, cartService, console));
        commands.put("4", new CheckoutCommand(inventoryService, cartService, console));
        commands.put("5", new ExitCommand());
    }

    public void run() {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Shopping Cart Menu ===");
            System.out.println("1. Display Cart");
            System.out.println("2. Add Item");
            System.out.println("3. Remove Item");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.println("Choose an option: ");

            String choice = console.nextLine();
            CommandManager command = commands.get(choice);

            if (command != null) {
                running = command.execute();
            } else {
                System.out.println("Invalid choice. Please choose an option 1 - 5");
            }
        }
    }
}

