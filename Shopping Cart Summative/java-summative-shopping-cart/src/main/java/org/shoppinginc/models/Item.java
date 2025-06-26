package org.shoppinginc.models;


public class Item {
    private String name;
    private double price;
    private String sku;
    private String category;

    public Item(String name, double price, String sku, String category) {
        this.name = name;
        this.price = price;
        this.sku = sku;
        this.category = category;
    }

    public String getName() {
        return name;
    }

     public double getPrice() {
        return price;
    }

    public String getSku() {
        return sku;
    }

      public String getCategory() {
        return category;
    }


        @Override
        public String toString () {
            return name + " ($" + price + ") - SKU: " + sku + ", Category: " + category;


        }
    }

