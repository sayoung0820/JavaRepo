package com.inventorymanager.service;
import com.inventorymanager.model.CartItem;
import com.inventorymanager.model.InventoryItem;
import com.inventorymanager.model.Result;
import com.inventorymanager.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartService {
    private final InventoryRepository inventoryRepository;
    private final Map<String, CartItem> cart = new HashMap<>();

    @Autowired
    public CartService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Result<Void> addToCart(String productId, int quantity) {
        if (productId == null || productId.trim().isEmpty()) {
            return new Result<>(false, "Product ID cannot be null or empty", null);
        }
        if (quantity <= 0) {
            return new Result<>(false, "Quantity must be greater than 0", null);
        }

        InventoryItem item = inventoryRepository.getById(productId);
        if (item == null) {
            return new Result<>(false, "Product ID not found: " + productId, null);
        }

        int currentCartQuantity = cart.containsKey(productId) ? cart.get(productId).getQuantity() : 0;
        int newTotalQuantity = currentCartQuantity + quantity;

        if (newTotalQuantity > item.getQuantity()) {
            return new Result<>(false,
                    String.format("Not enough in stock. Available: %d, Requested: %d",
                            item.getQuantity(), newTotalQuantity), null);
        }

        if (cart.containsKey(productId)) {
            CartItem existingCartItem = cart.get(productId);
            existingCartItem.setQuantity(newTotalQuantity);
        } else {
            BigDecimal price = item.getPrice().setScale(2, RoundingMode.HALF_UP);
            CartItem newCartItem = new CartItem(item.getProduct(), newTotalQuantity, price);
            cart.put(productId, newCartItem);
        }

        return new Result<>(true,
                String.format("Added %d of '%s' to cart", quantity, item.getProduct().getProductId()), null);
    }

    public Result<Void> removeFromCart(String productId, int quantity) {
        if (productId == null || productId.trim().isEmpty()) {
            return new Result<>(false, "Product ID cannot be null or empty", null);
        }
        if (quantity <= 0) {
            return new Result<>(false, "Quantity must be greater than 0", null);
        }

        if (!cart.containsKey(productId)) {
            return new Result<>(false, "Item not in cart", null);
        }

        CartItem cartItem = cart.get(productId);
        int currentQuantity = cartItem.getQuantity();
        productId = cartItem.getProduct().getProductId();

        if (quantity >= currentQuantity) {
            cart.remove(productId);
            return new Result<>(true,
                    String.format("Removed all of '%s' from cart", productId), null);
        } else {
            cartItem.setQuantity(currentQuantity - quantity);
            return new Result<>(true,
                    String.format("Removed %d of '%s' from cart", quantity, productId), null);
        }
    }

    public Result<BigDecimal> getTotalPrice() {
        BigDecimal total = BigDecimal.ZERO;

        for (CartItem cartItem : cart.values()) {
            total = total.add(cartItem.getExtendedPrice());
        }

        return new Result<>(true, "Total calculated successfully", total.setScale(2, RoundingMode.HALF_UP));
    }

    public Result<String> checkout() {
        if (cart.isEmpty()) {
            return new Result<>(false, "Cart is empty", null);
        }

        Result<BigDecimal> totalResult = getTotalPrice();
        if (!totalResult.isSuccess()) {
            return new Result<>(false, totalResult.getMessage(), null);
        }
        BigDecimal total = totalResult.getData();

        for (Map.Entry<String, CartItem> entry : cart.entrySet()) {
            String productId = entry.getKey();
            CartItem cartItem = entry.getValue();
            int purchasedQuantity = cartItem.getQuantity();

            InventoryItem item = inventoryRepository.getById(productId);
            item.setQuantity(item.getQuantity() - purchasedQuantity);
            inventoryRepository.update(item);
        }

        cart.clear();

        return new Result<>(true,
                String.format("Checkout successful! Total: $%s", total),
                String.format("$%s", total));
    }

    public List<CartItem> getCartContents() {
        return new ArrayList<>(cart.values());
    }

    public boolean isEmpty() {
        return cart.isEmpty();
    }
}

