package com.inventorymanager.model;
import java.math.BigDecimal;

public class InternationalProduct extends Product {
    private String countryOfOrigin;
    private BigDecimal importFee;


    public InternationalProduct(String productId, String productName, int quantity, BigDecimal price, String countryOfOrigin, BigDecimal importFee) {
        super(productId, productName, quantity, price);
        this.countryOfOrigin = countryOfOrigin;
        this.importFee = importFee;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public BigDecimal getImportFee() {
        return importFee;
    }

    public void setImportFee(BigDecimal importFee) {
        this.importFee = importFee;
    }

    @Override
    public String toString() {
        return String.format("%s | Country of Origin: %s",
                super.toString(), countryOfOrigin);

    }
}
