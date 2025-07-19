package com.inventorymanager;
import com.inventorymanager.model.CartItem;
import com.inventorymanager.model.InventoryItem;
import com.inventorymanager.model.Product;
import com.inventorymanager.model.Result;
import com.inventorymanager.repository.InMemoryInventoryRepository;
import com.inventorymanager.repository.InventoryRepository;
import com.inventorymanager.service.CartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CartServiceTests {
    private InventoryRepository inventoryRepository;
    private CartService cartService;

    private Product product1;
    private Product product2;
    private InventoryItem inventoryItem1;
    private InventoryItem inventoryItem2;

    @BeforeEach
    void setUp() {
        inventoryRepository = new InMemoryInventoryRepository();
        cartService = new CartService(inventoryRepository);

        product1 = new Product("P001", "Palm Oil", 10, new BigDecimal("2.00"));
        product2 = new Product("P002", "Oblong Tea", 20, new BigDecimal("1.00"));

        inventoryItem1 = new InventoryItem(product1, 10, new BigDecimal("2.00"));
        inventoryItem2 = new InventoryItem(product2,20, new BigDecimal("1.00"));

        inventoryRepository.add(inventoryItem1);
        inventoryRepository.add(inventoryItem2);
    }

    private CartItem findCartItemById(List<CartItem> cartItems, String productId) {
        return cartItems.stream()
                .filter(item -> item.getProduct().getProductId().equals(productId))
                .findFirst()
                .orElse(null);
    }

    @Test
    void addToCart_validProduct_ReturnSuccess() {
        Result<Void> result = cartService.addToCart("P001", 3);

        assertTrue(result.isSuccess());
        assertEquals("Added 3 of 'P001' to cart", result.getMessage());

        List<CartItem> cartItems = cartService.getCartContents();
        CartItem item = findCartItemById(cartItems, "P001");

        assertNotNull(item);
        assertEquals(3, item.getQuantity());
    }

    @Test
    void addToCart_NullProductId_ReturnsFailure() {
        Result<Void> result = cartService.addToCart(null, 1);

        assertFalse(result.isSuccess());
        assertEquals("Product ID cannot be null or empty", result.getMessage());
    }

    @Test
    void addToCart_InvalidProductId_ReturnsFailure() {
        Result<Void> result = cartService.addToCart("INVALID", 1);

        assertFalse(result.isSuccess());
        assertEquals("Product ID not found: INVALID", result.getMessage());
    }

    @Test
    void addToCart_WhitespaceIsbn_ReturnsFailure() {
        Result<Void> result = cartService.addToCart("   ", 1);

        assertFalse(result.isSuccess());
        assertEquals("Product ID cannot be null or empty", result.getMessage());
        assertTrue(cartService.isEmpty());
    }

    @Test
    void addToCart_InsufficientStock_ReturnsError() {
        Result<Void> result = cartService.addToCart("P002", 50);

        assertFalse(result.isSuccess());
        assertTrue(result.getMessage().contains("Not enough in stock"));
    }

    @Test
    void addToCart_ZeroQuantity_ReturnsFailure() {
        Result<Void> result = cartService.addToCart("P002", 0);

        assertFalse(result.isSuccess());
        assertEquals("Quantity must be greater than 0", result.getMessage());
        assertTrue(cartService.isEmpty());
    }

    @Test
    void removeFromCart_PartialQuantity_ReturnsSuccess() {
        cartService.addToCart("P001", 5);

        Result<Void> result = cartService.removeFromCart("P001", 2);

        assertTrue(result.isSuccess());
        assertEquals("Removed 2 of 'P001' from cart", result.getMessage());

        CartItem item = findCartItemById(cartService.getCartContents(), "P001");
        assertNotNull(item);
        assertEquals(3, item.getQuantity());
    }

    @Test
    void removeFromCart_RemovesAllQuantity_ReturnsSuccess() {
        cartService.addToCart("P001", 3);
        Result<Void> result = cartService.removeFromCart("P001", 3);

        assertTrue(result.isSuccess());
        assertEquals("Removed all of 'P001' from cart", result.getMessage());
        assertTrue(cartService.getCartContents().isEmpty());
    }

    @Test
    void getTotalPrice_CorrectlyCalculated() {
        cartService.addToCart("P001", 2); // 2 x 2.00
        cartService.addToCart("P002", 1); // 1 x 1.00

        Result<BigDecimal> result = cartService.getTotalPrice();
        assertTrue(result.isSuccess());

        BigDecimal expected = new BigDecimal("5.00"); // 4.00 + 1.00
        assertEquals(0, expected.compareTo(result.getData()));
    }

    @Test
    void checkout_ReducesInventoryAndClearsCart() {
        cartService.addToCart("P001", 3);
        Result<String> result = cartService.checkout();

        assertTrue(result.isSuccess());
        assertTrue(result.getMessage().contains("Checkout successful"));
        assertTrue(cartService.getCartContents().isEmpty());

        InventoryItem updated = inventoryRepository.getById("P001");
        assertEquals(7, updated.getQuantity()); // 10 - 3
    }


}
