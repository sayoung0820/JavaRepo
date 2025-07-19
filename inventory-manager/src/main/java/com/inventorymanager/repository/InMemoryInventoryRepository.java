package com.inventorymanager.repository;
import com.inventorymanager.model.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryInventoryRepository implements InventoryRepository {

    private final Map<String, InventoryItem> inventory = new HashMap<>();

    public InMemoryInventoryRepository() {
        initializeSampleData();
    }

    private void initializeSampleData() {
        // Basic Products
        addSampleProduct("P001", "Boxed Pasta", 20, new BigDecimal("1.99"));
        addSampleProduct("P002", "Cereal", 15, new BigDecimal("4.99"));

        // International Products
        addInternationalProduct("P003", "Imported Olive Oil", 10, new BigDecimal("10.99"), "Italy", new BigDecimal("50.00"));
        addInternationalProduct("P004", "Biltong", 10, new BigDecimal("10.99"), "South Africa", new BigDecimal("60.00"));

        // Perishable Products
        addPerishableProduct("P005", "Sirloin Steak", 40, new BigDecimal("20.99"), "08/05/2025");
        addPerishableProduct("P006", "Milk", 30, new BigDecimal("2.99"), "08/10/2025");

    }

    private void addSampleProduct(String productId, String productName, int quantity, BigDecimal price) {
        Product product = new Product(productId, productName, quantity, price);
        inventory.put(productId, new InventoryItem(product, quantity, price));
    }

    private void addInternationalProduct(String productId, String productName, int quantity, BigDecimal price, String countryOfOrigin, BigDecimal importFee) {
        InternationalProduct product = new InternationalProduct(productId, productName, quantity, price, countryOfOrigin, importFee);
        inventory.put(productId, new InventoryItem(product, quantity,price));
    }

    private void addPerishableProduct(String productId, String productName, int quantity, BigDecimal price, String expirationDate) {
        PerishableProduct product = new PerishableProduct(productId, productName, quantity, price, expirationDate);
        inventory.put(productId, new InventoryItem(product, quantity, price));
    }


    @Override
    public List<InventoryItem> getAll() {
        return new ArrayList<>(inventory.values());
    }

    @Override
    public InventoryItem getById(String productId) {
        if (productId == null || productId.trim().isEmpty()) {
            throw new IllegalArgumentException("Product ID cannot be null or empty");
        }
        return inventory.get(productId);
    }

    @Override
    public void add(InventoryItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        inventory.put(item.getProduct().getProductId(), item);
    }

    public void update(InventoryItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        String productId = item.getProduct().getProductId();
        if (!inventory.containsKey(productId)) {
            throw new IllegalArgumentException("Product with Product ID: " + productId + " not found");
        }
        inventory.put(productId, item);
    }

    @Override
    public void remove(String productId) {
        if (productId == null || productId.trim().isEmpty()) {
            throw new IllegalArgumentException("Product ID cannot be null or empty");
        }
        inventory.remove(productId);
    }
}
