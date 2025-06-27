package org.shoppinginc.commands;
import org.shoppinginc.models.Cart;
import org.shoppinginc.services.CartService;
import org.shoppinginc.services.InventoryService;

import java.util.Map;
import java.util.Scanner;

public class RemoveItemCommand implements CommandManager {
    private InventoryService inventoryService;
    private CartService cartService;
    private Scanner console;

    public RemoveItemCommand(InventoryService inventoryService, CartService cartService, Scanner console) {
        this.inventoryService = inventoryService;
        this.cartService = cartService;
        this.console = console;
    }

    public boolean execute() {
        if (cartService.isCartEmpty()) {
        } else {
            System.out.println("Current Cart Items: ");
            for (Cart cartItem : cartService.getCartItems().values()) {
                System.out.println(cartItem);
            }
            System.out.println("Enter the SKU of the item you want to remove: ");
            String skuToRemove = console.nextLine().toUpperCase();
            System.out.println("Enter quantity to remove: ");
            int qtyToRemove = Integer.parseInt(console.nextLine());

            Map<String, Cart> cartItems = cartService.getCartItems();
            if (cartItems.containsKey(skuToRemove)) {
                Cart cartItem = cartItems.get(skuToRemove);
                int currentQty = cartItem.getQuantity();

                if (qtyToRemove > currentQty) {
                    System.out.println("You can't remove more than you have!");
                } else if (qtyToRemove == currentQty) {
                    cartService.removeItem(skuToRemove);
                    System.out.println("Item(s) removed from cart.");
                } else {
                    cartItem.setQuantity(currentQty - qtyToRemove);
                    System.out.println("Quantity updated to " + cartItem.getQuantity() + " of: " + cartItem.getItem().getName());
                }
            } else {
                System.out.println("SKU not found in cart.");
            }
        }
        return true;
    }

}
