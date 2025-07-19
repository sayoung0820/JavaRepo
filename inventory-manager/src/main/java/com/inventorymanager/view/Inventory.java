package com.inventorymanager.view;
import com.inventorymanager.model.InventoryItem;
import com.inventorymanager.model.Product;
import com.inventorymanager.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.List;

@Component
public class Inventory {
    private final InventoryService inventoryService;
    private final InventoryIO inventoryIO;

    @Autowired
    public Inventory(InventoryService inventoryService, InventoryIO inventoryIO) {
        this.inventoryService = inventoryService;
        this.inventoryIO = inventoryIO;
    }

    public void run() {
        inventoryIO.displayWelcome();

        boolean running = true;
        while (running) {
            int choice = inventoryIO.displayMenuAndGetChoice();

            switch (choice) {
                case 1:
                    handleAddOrUpdateItem();
                    break;
                case 2:
                    handleRemoveItem();
                    break;
                case 3:
                    handleViewItem();
                    break;
                case 4:
                    handleViewAllItems();
                    break;
                case 5:
                    running = false;
                    inventoryIO.displayGoodbye();
                    break;
                default:
                    inventoryIO.displayError("Invalid choice. Please try again.");
            }
        }
    }

    private void handleAddOrUpdateItem() {
        inventoryIO.displaySectionHeader("Add/Update Inventory Item");

        String productId = inventoryIO.getStringInput("Enter Product ID: ");
        if (productId == null) return;

        String name = inventoryIO.getStringInput("Enter Product Name: ");
        if (name == null) return;

        Integer quantity = inventoryIO.getIntegerInput("Enter Quantity: ");
        if (quantity == null) return;

        BigDecimal price = inventoryIO.getBigDecimalInput("Enter Price: $");
        if (price == null) return;

        try {
            Product product = new Product(productId, name, quantity, price);
            InventoryItem item = new InventoryItem(product, quantity, price);

            InventoryItem existingItem = inventoryService.getItem(productId);
            inventoryService.updateOrAddItem(item);

            if (existingItem != null) {
                inventoryIO.displaySuccess("Item updated successfully!");
            } else {
                inventoryIO.displaySuccess("Item added successfully!");
            }
        } catch (Exception e) {
            inventoryIO.displayError("Failed to add/update item: " + e.getMessage());
        }
    }

    private void handleRemoveItem() {
        inventoryIO.displaySectionHeader("Remove Inventory Item");

        List<InventoryItem> allItems = inventoryService.getAllItems();
        if (allItems.isEmpty()) {
            inventoryIO.displayInfo("No items in inventory.");
            return;
        }

        inventoryIO.displayInventoryItems(allItems);

        String productId = inventoryIO.getStringInput("Enter Product ID to remove: ");
        if (productId == null) return;

        InventoryItem existingItem = inventoryService.getItem(productId);
        if (existingItem == null) {
            inventoryIO.displayError("Item with Product ID '" + productId + "' not found.");
            return;
        }

        inventoryIO.displaySectionHeader("Item to Remove");
        inventoryIO.displaySingleItem(existingItem);

        boolean confirm = inventoryIO.getConfirmation("Are you sure you want to remove this item? (y/n): ");
        if (!confirm) {
            inventoryIO.displayInfo("Remove operation cancelled.");
            return;
        }

        try {
            inventoryService.removeItem(productId);
            inventoryIO.displaySuccess("Item removed successfully!");
        } catch (Exception e) {
            inventoryIO.displayError("Failed to remove item: " + e.getMessage());
        }
    }

    private void handleViewItem() {
        inventoryIO.displaySectionHeader("View Inventory Item");

        String productId = inventoryIO.getStringInput("Enter Product ID: ");
        if (productId == null) return;

        InventoryItem item = inventoryService.getItem(productId);
        if (item == null) {
            inventoryIO.displayError("Item with Product ID '" + productId + "' not found.");
            return;
        }

        inventoryIO.displaySingleItem(item);
    }

    private void handleViewAllItems() {
        inventoryIO.displaySectionHeader("All Inventory Items");

        List<InventoryItem> allItems = inventoryService.getAllItems();
        if (allItems.isEmpty()) {
            inventoryIO.displayInfo("No items in inventory.");
            return;
        }

        inventoryIO.displayInventoryItems(allItems);
        inventoryIO.displayInfo("Total items in inventory: " + allItems.size());
    }
}
