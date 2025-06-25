package org.shoppinginc.services;
import org.shoppinginc.model.Cart;
import org.shoppinginc.model.Item;
import java.util.Map;

public interface CartServiceManager {


    void addItem(Item item);
    void removeItem(String sku);
    void clearCart();
    Map<String, Cart> getCartItems();
    double calculateTotal();
    boolean isCartEmpty();
}
