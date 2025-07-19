package com.inventorymanager.model;

import java.math.BigDecimal;

public class Product {

    private final String productId;
    private final String productName;
    private int quantity;
    private BigDecimal price;

    public Product(String productId, String productName, int quantity, BigDecimal price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Product [ID: %s, Name: %s, Qty: %d, Price: $%.2f])",
                productId, productName, quantity, price);

    }
}
