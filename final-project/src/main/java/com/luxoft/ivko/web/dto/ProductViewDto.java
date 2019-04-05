package com.luxoft.ivko.web.dto;

import java.io.Serializable;
import java.util.Objects;

public class ProductViewDto implements Serializable {
    private Long id;
    private String name;
    private String productType;
    private String price;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
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
        if (!(o instanceof ProductViewDto)) return false;
        ProductViewDto that = (ProductViewDto) o;
        return getId().equals(that.getId()) &&
                getName().equals(that.getName()) &&
                getProductType().equals(that.getProductType()) &&
                getPrice().equals(that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getProductType(), getPrice());
    }
}
