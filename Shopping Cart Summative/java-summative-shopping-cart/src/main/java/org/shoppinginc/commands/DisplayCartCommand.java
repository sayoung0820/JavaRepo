package org.shoppinginc.commands;
import org.shoppinginc.models.Cart;
import org.shoppinginc.services.CartService;
import org.shoppinginc.services.InventoryService;

import java.util.Scanner;

public class DisplayCartCommand implements CommandManager {
    private InventoryService inventoryService;
    private CartService cartService;
    private Scanner console;

    public DisplayCartCommand(InventoryService inventoryService, CartService cartService, Scanner console) {
        this.inventoryService = inventoryService;
        this.cartService = cartService;
        this.console = console;
    }

    @Override
    public boolean execute() {
        System.out.println("Current items in cart: ");
        if (cartService.isCartEmpty()) {
        } else {
            for (Cart cartItem : cartService.getCartItems().values()) {
                System.out.println(cartItem);
            }
        }
        return true;
    }
}
