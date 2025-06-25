package org.shoppinginc.services;
import org.shoppinginc.model.Cart;
import org.shoppinginc.model.Item;
import java.util.HashMap;
import java.util.Map;


public class CartService implements CartServiceManager {
    private Map<String, Cart> cartItems = new HashMap<>();

    @Override
    public void addItem(Item item) {
        String sku = item.getSku();
        if (cartItems.containsKey(sku)) {
            Cart existing = cartItems.get(sku);
            existing.setQuantity(existing.getQuantity() + 1);
        } else {
            Cart newItem = new Cart(item, 1);
            cartItems.put(sku, newItem);
        }
    }

    @Override
    public void removeItem(String sku) {
        if (cartItems.containsKey(sku)) {
            cartItems.remove(sku);
        } else {
            System.out.println("Item sku not found.");
        }
    }

    @Override
    public void clearCart() {
        cartItems.clear();
        System.out.println("Cart has been cleared.");
    }

    @Override
    public Map<String, Cart> getCartItems() {
        return cartItems;
    }

    @Override
    public double calculateTotal() {
        double total = 0.0;
        for (Cart cartItem : cartItems.values()) {
            total += cartItem .getTotalPrice();
        }
        return total;
    }

    @Override
    public boolean isCartEmpty() {
        boolean empty = cartItems.isEmpty();
        if (empty) {
            System.out.println("The cart is empty.");
        } else {
        }
        return empty;
    }
}

