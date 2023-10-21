package Entities;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

public class Product {
    private static AtomicInteger nextProductId = new AtomicInteger(1000);
    private Integer productID;
    private String name;
    private BigDecimal price;
    private int quantity;
    private String size;
    private String category;
    private String manufacturer;
    private String description;
    private String expiryDate;

    public Product(String name, BigDecimal price, int quantity, String size, String category, String manufacturer, String description, String expiryDate) {
        this.productID = nextProductId.getAndIncrement();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.size = size;
        this.category = category;
        this.manufacturer = manufacturer;
        this.description = description;
        this.expiryDate = expiryDate;
        Inventory.addToInventoryCache(this);
    }

    public String getExpiryDate(){ return expiryDate;}


    public Integer getProductID() { return productID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public int getQuantity() {return this.quantity;}
    public void setQuantity(int i) { this.quantity = i; }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
