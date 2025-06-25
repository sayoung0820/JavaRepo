package org.shoppinginc.model;

public class Cart {
    private Item item;
    private int quantity;

    public Cart(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return quantity * item.getPrice();
    }

    @Override
    public String toString() {
        return item.getName() + " (SKU: " + item.getSku() + ") x " + quantity + " = $" + getTotalPrice();
    }
}

