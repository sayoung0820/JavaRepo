package org.shoppinginc.app;
import org.shoppinginc.models.Cart;
import org.shoppinginc.services.CartService;
import org.shoppinginc.services.InventoryService;
import org.shoppinginc.models.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] arg) {
        Scanner console = new Scanner(System.in);
        CartService cartService = new CartService();
        InventoryService inventoryService = new InventoryService();

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

            switch (choice) {
                case "1":
                    System.out.println("Current items in cart: ");
                    if (cartService.isCartEmpty()) {
                    } else {
                        for (Cart cartItem : cartService.getCartItems().values()) {
                            System.out.println(cartItem);
                        }
                    }
                    break;

                case "2":
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
                    break;

                case "3":
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
                    break;

                case "4":
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
                    break;

                case "5":
                    System.out.println("Thanks for using the Shopping Cart App. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please a number 1 - 5.");
            }
        }
    }
}













