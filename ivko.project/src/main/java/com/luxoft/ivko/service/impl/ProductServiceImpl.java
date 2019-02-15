package com.luxoft.ivko.service.impl;

import com.luxoft.ivko.domain.Product;
import com.luxoft.ivko.service.ProductService;

import java.math.BigDecimal;

public class ProductServiceImpl implements ProductService {

    @Override
    public Product createProduct(String name, BigDecimal price, String productType) {
        return null;
    }

    @Override
    public void modifyProduct(Product product, String newName, BigDecimal newPrice) {

    }

    @Override
    public void deleteProduct(BigDecimal id) {

    }
}