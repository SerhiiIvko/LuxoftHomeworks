package com.luxoft.ivko.web.dto;

import java.io.Serializable;
import java.util.Objects;

public class ProductCreateDto implements Serializable {
    private Long id;
    private String name;
    private String productType;
    private String price;


    public ProductCreateDto(Long id, String name, String productType, String price) {
        this.id = id;
        this.name = name;
        this.productType = productType;
        this.price = price;
    }

    public ProductCreateDto(String name, String productType, String price) {
        this(null, name, productType, price);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getProductType() {
        return productType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductCreateDto)) return false;
        ProductCreateDto createDto = (ProductCreateDto) o;
        return getId().equals(createDto.getId()) &&
                getName().equals(createDto.getName()) &&
                getProductType().equals(createDto.getProductType()) &&
                getPrice().equals(createDto.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getProductType(), getPrice());
    }
}
