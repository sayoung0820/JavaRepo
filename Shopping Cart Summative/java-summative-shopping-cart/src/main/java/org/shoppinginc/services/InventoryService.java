package org.shoppinginc.services;
import org.shoppinginc.models.Item;
import java.util.ArrayList;
import java.util.List;

public class InventoryService {
    private List<Item> inventory;

    public InventoryService() {
        inventory = new ArrayList<>();
        loadInventory();
    }

    private void loadInventory() {
        inventory.add(new Item("Apple", 0.99, "A598", "Fruit"));
        inventory.add(new Item("Bread", 1.99, "B621", "Bakery"));
        inventory.add(new Item("Rice",  2.50, "C759", "Grains"));
        inventory.add(new Item("Cereal",3.99, "D843", "Dry Goods"));
        inventory.add(new Item("Squash",0.99, "W462", "Vegetable"));
        inventory.add(new Item("Almonds",6.99, "T625", "Nuts"));
        inventory.add(new Item("Juice", 2.99,  "L491", "Beverage"));
        inventory.add(new Item("Steak", 10.99, "M524", "Meat"));
        inventory.add(new Item("Shrimp",11.99, "S203", "Seafood"));
        inventory.add(new Item("Chips", 1.99,  "P746", "Snacks"));
        inventory.add(new Item("Eggs",  4.99,  "E984", "Dairy"));
        inventory.add(new Item("Milk",  3.99,  "U465", "Dairy"));
        inventory.add(new Item("Wine",  20.99, "W864", "Alcohol"));
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public Item getItemBySku(String sku) {
        for (Item item : inventory) {
            if (item.getSku().equalsIgnoreCase(sku)) {
                return item;
            }
        }
        return null;
    }

    public Item getItemByIndex(int i) {
        if (i >= 0 && i < inventory.size()) {
            return inventory.get(i);
        }
        return null;
    }

    public void displayInventory() {
        System.out.println("========== Available Items ===========");
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            System.out.println((i + 1) + ". " + item);
        }
    }
}
