package com.inventorymanager.model;
import java.math.BigDecimal;

public class InventoryItem {
    private final Product product;
    private int quantity;
    private BigDecimal price;

    public InventoryItem(Product product, int quantity, BigDecimal price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s - Stock: %d - Price: $%.2f", product.toString(), quantity, price);
    }

    public String formatForDisplay() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%-10s | %-25s | Qty: %-4d | $%-8.2f",
                product.getProductId(),
                product.getProductName(),
                quantity,
                price
        ));

        if (product instanceof PerishableProduct) {
            String expiry = ((PerishableProduct) product).getExpirationDate();
            sb.append(String.format(" | Expires: %-10s", expiry));
        }

        if (product instanceof InternationalProduct) {
            String country = ((InternationalProduct) product).getCountryOfOrigin();
            BigDecimal fee = ((InternationalProduct) product).getImportFee();
            sb.append(String.format(" | Origin: %-15s | Fee: $%-5.2f", country, fee));
        }

        return sb.toString();
    }
}
