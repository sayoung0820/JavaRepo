package com.inventorymanager.service;
import com.inventorymanager.model.InventoryItem;
import com.inventorymanager.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public void updateOrAddItem(InventoryItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }

        String productId = item.getProduct().getProductId();
        InventoryItem existingItem = inventoryRepository.getById(productId);

        if (existingItem != null) {
            existingItem.setQuantity(item.getQuantity());
            existingItem.setPrice(item.getPrice());
            inventoryRepository.update(existingItem);
        } else {
            inventoryRepository.add(item);
        }
    }

    public void removeItem(String productId) { inventoryRepository.remove(productId);}

    public InventoryItem getItem(String productId) { return inventoryRepository.getById(productId); }

    public List<InventoryItem> getAllItems() { return inventoryRepository.getAll(); }
}
