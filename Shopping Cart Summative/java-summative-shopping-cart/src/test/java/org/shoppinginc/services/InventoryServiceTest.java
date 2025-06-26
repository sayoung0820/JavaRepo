package org.shoppinginc.services;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.shoppinginc.models.Item;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class InventoryServiceTest {
    private InventoryService inventoryService;

    @BeforeEach
    public void setup() {
        inventoryService = new InventoryService();
    }

    @Test
    public void testToLoadInventory() {
        List<Item> inventory = inventoryService.getInventory();
        assertFalse(inventory.isEmpty(), "Inventory should not be empty.");
        assertEquals(13, inventory.size(), "Inventory should contain 13 items.");
    }

    @Test
    public void testGetItemsByValidSku() {
        Item item = inventoryService.getItemBySku("A598");
        assertNotNull(item, "Item with SKU 'A598' should exist in the inventory");
        assertEquals("Apple", item.getName());
    }

    @Test
    public void testToReturnErrorForInvalidSku() {
        Item item = inventoryService.getItemBySku("Z658");
        assertNull(item, "Item with non-existent SKU should return null");
    }


}
