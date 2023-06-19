package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="product")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
    @JsonProperty("name")
    @XmlElement(name="name")
    private String name;
    @JsonProperty("description")
    @XmlElement(name="description")
    private String description;
    @JsonProperty("price")
    @XmlElement(name="price")
    private double price;
    @JsonProperty("stock_quantity")
    @XmlElement(name="stock_quantity")
    private int stockQuantity;

    public Product() {}

    public Product(String name, String description, double price, int stockQuantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

}
