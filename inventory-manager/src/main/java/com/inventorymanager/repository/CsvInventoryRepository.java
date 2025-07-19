package com.inventorymanager.repository;
import com.inventorymanager.model.InternationalProduct;
import com.inventorymanager.model.InventoryItem;
import com.inventorymanager.model.PerishableProduct;
import com.inventorymanager.model.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.*;

public class CsvInventoryRepository implements InventoryRepository {

    private final Map<String, InventoryItem> inventory = new HashMap<>();
    @Value("${inventory.csv.filepath:data/inventory.csv}")
    private String filename;

    @PostConstruct
    public void init() {
        loadFromFile();
    }

    @Override
    public List<InventoryItem> getAll() {
        return new ArrayList<>(inventory.values());
    }

    @Override
    public InventoryItem getById(String productId) {
        if (productId == null || productId.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        return inventory.get(productId);
    }

    @Override
    public void add(InventoryItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        inventory.put(item.getProduct().getProductId(), item);
        saveToFile();
    }

    @Override
    public void update(InventoryItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        String productId = item.getProduct().getProductId();
        if (!inventory.containsKey(productId)) {
            throw new IllegalArgumentException("Item with Product ID: " + productId + " not found");
        }
        inventory.put(productId, item);
        saveToFile();
    }

    @Override
    public void remove(String productId) {
        if (productId == null || productId.trim().isEmpty()) {
            throw new IllegalArgumentException("Product ID cannot be null or empty");
        }
        inventory.remove(productId);
        saveToFile();
    }

    private void loadFromFile() {
        File file = new File(filename);
        if (!file.exists()) {
            return;
        }

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                reader.readLine();
                String line;

                while ((line = reader.readLine()) != null) {
                    if (line.trim().isEmpty()) continue;

                    String[] parts = line.split(",");
                    if (parts.length < 4)
                        continue;

                    String productId = parts[0].trim();
                    String productName = parts[1].trim();
                    int quantity = Integer.parseInt(parts[2].trim());
                    BigDecimal price = new BigDecimal(parts[3].trim());
                    String expirationDate = parts.length > 4 ? parts[4].trim() : "";
                    String countryOfOrigin = parts.length > 5 ? parts[5].trim() : "";
                    String importFeeStr = parts.length > 6 ? parts[6].trim() : "";

                    Product product;

                    if (!countryOfOrigin.isEmpty() && !importFeeStr.isEmpty()) {
                        BigDecimal importFee = new BigDecimal(importFeeStr);
                        product = new InternationalProduct(productId, productName, quantity, price, countryOfOrigin, importFee);
                    } else if (!expirationDate.isEmpty()) {
                        product = new PerishableProduct(productId, productName, quantity, price, expirationDate);
                    } else {
                        product = new Product(productId, productName, quantity, price);
                    }
                    if (product instanceof PerishableProduct) {
                        ((PerishableProduct) product).setExpirationDate(expirationDate);
                    }
                    inventory.put(productId, new InventoryItem(product, quantity, price));
                }
            } catch (IOException e) {
                throw new RuntimeException("Error reading from file: " + filename, e);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Error parsing number from file: " + filename, e);
            }
        }


            private void saveToFile () {
                try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
                    writer.println("productId,name,quantity,price,expirationDate,countryOfOrigin,importFee");

                    for (InventoryItem item : inventory.values()) {
                        Product product = item.getProduct();
                        String productId = product.getProductId();
                        String name = product.getProductName();
                        int quantity = item.getQuantity();
                        BigDecimal price = item.getPrice();
                        String expirationDate = "";
                        String countryOfOrigin = "";
                        String importFee = "";

                        if (product instanceof PerishableProduct) {
                            expirationDate = ((PerishableProduct) product).getExpirationDate();
                        }
                        if (product instanceof InternationalProduct) {
                            countryOfOrigin = ((InternationalProduct) product).getCountryOfOrigin();
                            importFee = ((InternationalProduct) product).getImportFee().toString();
                        }
                        writer.printf("%s,%s,%d,%.2f, %s,%s,%s%n",
                                productId,
                                name,
                                quantity,
                                price,
                                expirationDate,
                                countryOfOrigin,
                                importFee);

                    }
                } catch (IOException e) {
                    throw new RuntimeException("Error writing to file: " + filename, e);
                }
            }
        }




