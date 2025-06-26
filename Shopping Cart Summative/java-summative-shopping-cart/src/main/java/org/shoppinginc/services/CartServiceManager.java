package org.shoppinginc.services;
import org.shoppinginc.models.Cart;
import org.shoppinginc.models.Item;
import java.util.Map;

public interface CartServiceManager {


    void addItem(Item item);
    void removeItem(String sku);
    void clearCart();
    Map<String, Cart> getCartItems();
    double calculateTotal();
    boolean isCartEmpty();
}
