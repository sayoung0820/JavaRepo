package org.shoppinginc.commands;
import org.shoppinginc.models.Cart;
import org.shoppinginc.services.CartService;
import org.shoppinginc.services.InventoryService;
import java.util.Scanner;

public class CheckoutCommand implements CommandManager {
    private CartService cartService;
    private InventoryService inventoryService;
    private Scanner console;

    public CheckoutCommand(InventoryService inventoryService, CartService cartService, Scanner console) {
        this.cartService = cartService;
        this.inventoryService = inventoryService;
        this.console = console;
    }

    @Override
    public boolean execute() {
        if (cartService.isCartEmpty()) {
        } else {
            System.out.println("========== Receipt ==========");
            for (Cart cartItem : cartService.getCartItems().values()) {
                System.out.println(cartItem);
            }
            double total = cartService.calculateTotal();
            System.out.printf("\nTotal Amount Due: $%.2f%n", total);
            System.out.println("\nThanks for shopping with us today!");
            cartService.clearCart();
        }
        return true;
    }

}
