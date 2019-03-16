package com.luxoft.ivko.web.dto;

import java.io.Serializable;

public class ProductCreateDto implements Serializable {
    private Long id;
    private String name;
    private String price;
    private String productType;


    public ProductCreateDto(Long id, String name, String price, String productType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productType = productType;
    }

    public ProductCreateDto(String name, String price, String productType) {
        this(null, name, price, productType);
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
}
