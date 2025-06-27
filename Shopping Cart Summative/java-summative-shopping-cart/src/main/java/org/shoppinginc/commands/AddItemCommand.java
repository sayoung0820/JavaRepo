package org.shoppinginc.commands;
import org.shoppinginc.models.Item;
import org.shoppinginc.services.CartService;
import org.shoppinginc.services.InventoryService;
import java.util.List;
import java.util.Scanner;

public class AddItemCommand implements CommandManager {
    private InventoryService inventoryService;
    private CartService cartService;
    private Scanner console;


    public AddItemCommand(InventoryService inventoryService, CartService cartService, Scanner console) {
        this.inventoryService = inventoryService;
        this.cartService = cartService;
        this.console = console;
    }

    @Override
    public boolean execute() {
        inventoryService.displayInventory();
        System.out.println("\nEnter the number of the item to add 1 - 13: ");
        int itemNumber = Integer.parseInt(console.nextLine());
        List<Item> inventory = inventoryService.getInventory();
        if (itemNumber < 1 || itemNumber > inventory.size()) {
            System.out.println("Invalid item number.");
        } else {
            Item selectedItem = inventory.get(itemNumber - 1);
            cartService.addItem(selectedItem);
            System.out.println(selectedItem.getName() + " added to cart.");
        }
        return true;
    }
}
