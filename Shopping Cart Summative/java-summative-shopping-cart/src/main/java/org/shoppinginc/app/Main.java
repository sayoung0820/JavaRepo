package org.shoppinginc.app;
import org.shoppinginc.services.CartService;
import org.shoppinginc.services.InventoryService;
import org.shoppinginc.commands.MenuRunner;


public class Main {
    public static void main(String[] arg) {
        CartService cartService = new CartService();
        InventoryService inventoryService = new InventoryService();

        MenuRunner runner = new MenuRunner(cartService, inventoryService);
        runner.run();
    }
}
















