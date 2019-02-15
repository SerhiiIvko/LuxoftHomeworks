package com.luxoft.ivko.dao;

import com.luxoft.ivko.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductDao {
    boolean saveProduct(Product product);
    Product getProductById(BigDecimal id);
    Product getProductByEmail(String email);
    List<Product> getAllProducts();
}