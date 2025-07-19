package com.inventorymanager.view;
import com.inventorymanager.model.CartItem;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

@Component
public class KioskIO {

    private final Scanner scanner = new Scanner(System.in);

    public void displayWelcome() {
        System.out.println("\n===============================");
        System.out.println("   Welcome to the Kiosk System");
        System.out.println("===============================\n");
    }

    public int displayMenuAndGetChoice() {
        System.out.println("\nKiosk Menu:");
        System.out.println("1. Add item to cart");
        System.out.println("2. Remove item from cart");
        System.out.println("3. View cart");
        System.out.println("4. Checkout");
        System.out.println("5. Exit kiosk");
        System.out.print("Enter your choice: ");
        return readInt();
    }

    public String getProductIdInput() {
        System.out.print("Enter Product ID: ");
        return scanner.nextLine().trim();
    }

    public int getQuantityInput() {
        System.out.print("Enter Quantity: ");
        return readInt();
    }

    public void displayCartItems(List<CartItem> cartItems) {
        if (cartItems.isEmpty()) {
            System.out.println("Cart is currently empty.");
        } else {
            System.out.println("\nItems in Cart:");
            for (CartItem item : cartItems) {
                System.out.println(item);
            }
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }

    public void displaySuccess(String successMessage) {
        System.out.println("✅ " + successMessage);
    }

    public void displayTotal(BigDecimal total) {
        System.out.printf("Total: $%.2f%n", total);
    }

    private int readInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }
}
