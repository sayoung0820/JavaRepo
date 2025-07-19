package com.inventorymanager.repository;
import com.inventorymanager.model.*;
import java.util.List;

public interface InventoryRepository {

    List<InventoryItem> getAll();

    InventoryItem getById(String productId);

    void add(InventoryItem item);

    void update(InventoryItem item);

    void remove(String productId);

}
