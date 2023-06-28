package restock.restock;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Product {
    private String name;
    private String brand;
    private String sku;
    private String category;
    @JsonProperty("unit_price")
    private double unitPrice;
    @JsonProperty("expiration_date")
    private long expirationDate;
    @JsonProperty("batch_number")
    private String batchNumber;
    private String supplier;






    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    } 

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSKU() {
        return sku;
    }
    public void setSKU(String sku) {
        this.sku = sku;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public Double getUnit_Price() {
        return unitPrice;
    }
    public void setUnit_Price(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public long getExpiration_date() {
        return expirationDate;
    }
    public void setExpiration_date(long expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getBatch_number() {
        return batchNumber;
    }
    public void setBatch_number(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getSupplier() {
        return supplier;
    }
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
