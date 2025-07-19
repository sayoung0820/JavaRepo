package com.inventorymanager.model;

import java.math.BigDecimal;

public class PerishableProduct extends Product {
    private String expirationDate;
    private boolean isFrozen = true;


    public PerishableProduct(String productId, String productName, int quantity, BigDecimal price, String expirationDate) {
        super(productId, productName, quantity, price);
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isFrozen() {
        return isFrozen;
    }

    public void setFrozen(boolean frozen) {
        isFrozen = frozen;

    }

    @Override
    public String toString() {
        return String.format("%s | Expires: %s | Frozen %b",
                super.toString(), expirationDate, isFrozen);
    }
}
