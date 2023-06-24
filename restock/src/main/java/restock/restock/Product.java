import com.fasterxml.jackson.annotation.JsonProperty;

public class MilkProduct {
    @JsonProperty("name");
    private String name;
    @JsonProperty("brand");
    private String brand;
    @JsonProperty("sku");
    private String sku;
    @JsonProperty("category");
    private String category;
    @JsonProperty("unit_price")
    private double unitPrice;
    @JsonProperty("expiration_date")
    private String expirationDate;
    @JsonProperty("batch_number")
    private String batchNumber;
    @JsonProperty
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

    public String getUnit_Price() {
        return unit_price;
    }
    public void setUnit_Price(String unit_price) {
        this.unit_price = unit_price;
    }

    public String getExpiration_date() {
        return expiration_date;
    }
    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getBatch_number() {
        return batch_number;
    }
    public void setBatch_number(String batch_number) {
        this.batch_number = batch_number;
    }

    public String getSupplier() {
        return supplier;
    }
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
