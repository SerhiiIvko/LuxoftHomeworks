package com.luxoft.ivko.service;

import java.math.BigDecimal;

public interface ProductService {
    ProductService createProduct(String name, BigDecimal price, String productType);
    void modifyProduct(String newName, BigDecimal newPrice);
    void deleteProduct(BigDecimal id);
}