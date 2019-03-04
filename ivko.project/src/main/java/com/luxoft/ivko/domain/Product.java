package com.luxoft.ivko.domain;

import java.util.Objects;

public class Product {
    private Long id;
    private String name;
    private double price;
    private String productType;

    public Product() {
    }

    public Product(String name, double price, String productType) {
        this.name = name;
        this.price = price;
        this.productType = productType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id.equals(product.id) &&
                getName().equals(product.getName()) &&
                getPrice() == product.getPrice() &&
                getProductType().equals(product.getProductType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getName(), getPrice(), getProductType());
    }

    @Override
    public String toString() {
        return "Product: " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", productType='" + productType + '\'';
    }
}
