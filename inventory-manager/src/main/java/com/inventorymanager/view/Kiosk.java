package com.inventorymanager.view;
import com.inventorymanager.model.CartItem;
import com.inventorymanager.model.Result;
import com.inventorymanager.service.CartService;
import com.inventorymanager.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.List;

@Component
public class Kiosk {

    private final CartService cartService;
    private final KioskIO kioskIO;
    private final InventoryService inventoryService;

    @Autowired
    public Kiosk(CartService cartService, KioskIO kioskIO, InventoryService inventoryService) {
        this.cartService = cartService;
        this.kioskIO = kioskIO;
        this.inventoryService = inventoryService;
    }

    public void run() {
        kioskIO.displayWelcome();

        boolean running = true;
        while (running) {
            int choice = kioskIO.displayMenuAndGetChoice();

            switch (choice) {
                case 1:
                    handleAddToCart();
                    break;
                case 2:
                    handleRemoveFromCart();
                    break;
                case 3:
                    handleViewCart();
                    break;
                case 4:
                    handleCheckout();
                    break;
                case 5:
                    running = false;
                    kioskIO.displayMessage("Thank you! Goodbye.");
                    break;
                default:
                    kioskIO.displayError("Invalid choice. Please try again.");
            }
        }
    }

    private void handleAddToCart() {
        String productId = kioskIO.getProductIdInput();
        int quantity = kioskIO.getQuantityInput();

        Result<Void> result = cartService.addToCart(productId, quantity);
        if (result.isSuccess()) {
            kioskIO.displaySuccess(result.getMessage());
        } else {
            kioskIO.displayError(result.getMessage());
        }
    }

    private void handleRemoveFromCart() {
        String productId = kioskIO.getProductIdInput();
        int quantity = kioskIO.getQuantityInput();

        Result<Void> result = cartService.removeFromCart(productId, quantity);
        if (result.isSuccess()) {
            kioskIO.displaySuccess(result.getMessage());
        } else {
            kioskIO.displayError(result.getMessage());
        }
    }

    private void handleViewCart() {
        List<CartItem> cartItems = cartService.getCartContents();
        kioskIO.displayCartItems(cartItems);
    }

    private void handleCheckout() {
        Result<String> result = cartService.checkout();
        if (result.isSuccess()) {
            kioskIO.displaySuccess(result.getMessage());
        } else {
            kioskIO.displayError(result.getMessage());
        }
    }
}

