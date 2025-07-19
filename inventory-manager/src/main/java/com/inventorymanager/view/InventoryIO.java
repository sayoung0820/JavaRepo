package com.inventorymanager.view;
import com.inventorymanager.model.InventoryItem;
import com.inventorymanager.model.InternationalProduct;
import com.inventorymanager.model.PerishableProduct;
import com.inventorymanager.model.Product;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

@Component
public class InventoryIO {
    private final Scanner scanner = new Scanner(System.in);

    public void displayWelcome() {
        System.out.println("==================================");
        System.out.println(" Welcome to the Inventory Manager ");
        System.out.println("==================================");
    }

    public void displayGoodbye() {
        System.out.println("==================================");
        System.out.println("      Exiting Inventory Tool      ");
        System.out.println("==================================");
    }

    public int displayMenuAndGetChoice() {
        System.out.println("\nMenu Options:");
        System.out.println("1. Add or Update Item");
        System.out.println("2. Remove Item");
        System.out.println("3. View Item");
        System.out.println("4. View All Items");
        System.out.println("5. Exit");

        System.out.print("Enter your choice: ");
        String input = scanner.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void displaySectionHeader(String title) {
        System.out.println("\n--- " + title + " ---");
    }

    public void displaySuccess(String message) {
        System.out.println("[SUCCESS] " + message);
    }

    public void displayError(String message) {
        System.out.println("[ERROR] " + message);
    }

    public void displayInfo(String message) {
        System.out.println(message);
    }

    public String getStringInput(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        return input.isBlank() ? null : input.trim();
    }

    public Integer getIntegerInput(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            displayError("Invalid number entered.");
            return null;
        }
    }

    public BigDecimal getBigDecimalInput(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        try {
            return new BigDecimal(input.trim());
        } catch (NumberFormatException e) {
            displayError("Invalid decimal number.");
            return null;
        }
    }

    public boolean getConfirmation(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("y") || input.equals("yes");
    }

    public void displaySingleItem(InventoryItem item) {
        System.out.println("Item Details:");
        System.out.println(item.toString());
    }

    public void displayInventoryItems(List<InventoryItem> items) {
        System.out.printf("%-10s | %-25s | %-8s | %-8s | %-12s | %-15s | %-8s%n",
                "ID", "Name", "Qty", "Price", "Expires", "Origin", "Fee");
        System.out.println("-----------------------------------------------------------------------------------------------");

        for (InventoryItem item : items) {
            Product product = item.getProduct();
            String expirationDate = "";
            String country = "";
            String importFee = "";

            if (product instanceof PerishableProduct) {
                expirationDate = ((PerishableProduct) product).getExpirationDate();
            }

            if (product instanceof InternationalProduct) {
                InternationalProduct intl = (InternationalProduct) product;
                country = intl.getCountryOfOrigin();
                importFee = "$" + intl.getImportFee().setScale(2, BigDecimal.ROUND_HALF_UP);
            }

            System.out.printf("%-10s | %-25s | %-8d | $%-7.2f | %-12s | %-15s | %-8s%n",
                    product.getProductId(),
                    product.getProductName(),
                    item.getQuantity(),
                    item.getPrice(),
                    expirationDate,
                    country,
                    importFee);
        }
    }
}

