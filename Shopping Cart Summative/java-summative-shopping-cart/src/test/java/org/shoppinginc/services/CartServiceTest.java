package org.shoppinginc.services;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.shoppinginc.models.Item;
import static org.junit.jupiter.api.Assertions.*;

public class CartServiceTest {

    private CartService service;

    @BeforeEach
    public void setup() {
        service = new CartService();
    }

    @Test
    public void testAddItem() {
        Item item = new Item("Apple", 0.99, "A1", "Fruit");
        service.addItem(item);

        assertEquals(1, service.getCartItems().size());
    }

    @Test
    public void testRemoveItem() {
        Item item = new Item("Apple", 0.99, "A123", "Fruit");
        service.addItem(item);
        service.removeItem("A123");

        assertEquals(0, service.getCartItems().size());
    }

    @Test
    public void testSkuNotFound() {
        service.removeItem("B999");

        assertEquals(0, service.getCartItems().size(), "Cart should remain empty if item doesn't exist");
    }

    @Test
    public void testClearCart() {
        Item item = new Item("Apple", 0.99, "A1", "Fruit");
        Item item1 = new Item("Pear", 0.99, "A2", "Fruit");
        Item item2 = new Item("Lemon", 0.99, "A3", "Fruit");
        service.addItem(item);
        service.addItem(item1);
        service.addItem(item2);
        service.clearCart();

        assertEquals(0, service.getCartItems().size());
    }

    @Test
    public void testGetCartItems() {
        Item item = new Item("Apple", 0.99, "A1", "Fruit");
        Item item1 = new Item("Pear", 0.99, "A2", "Fruit");
        service.addItem(item);
        service.addItem(item1);

        assertEquals(2, service.getCartItems().size());
    }

    @Test
    public void testCalculateTotal() {
        Item item = new Item("Apple", 0.99, "A1", "Fruit");
        Item item1 = new Item("Pear", 0.99, "A2", "Fruit");
        Item item2 = new Item("Lemon", 0.99, "A3", "Fruit");
        service.addItem(item);
        service.addItem(item1);
        service.addItem(item2);
        double expectedTotal = 0.99 * 3;
        double actualTotal = service.calculateTotal();

        assertEquals(expectedTotal, actualTotal);
    }

    @Test
    public void testIsCartEmpty() {
        assertTrue(service.isCartEmpty(), "Cart should be initially empty");
        Item item = new Item("Apple", 0.99, "A1", "Fruit");
        service.addItem(item);

        assertFalse(service.isCartEmpty(), "Cart should be empty after adding an item");

    }
}
