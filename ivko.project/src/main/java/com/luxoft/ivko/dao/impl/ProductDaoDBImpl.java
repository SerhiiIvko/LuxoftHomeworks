package com.luxoft.ivko.dao.impl;

import com.luxoft.ivko.dao.ProductDao;
import com.luxoft.ivko.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public class ProductDaoDBImpl implements ProductDao {
    @Override
    public boolean saveProduct(Product product) {
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        return false;
    }

    @Override
    public Product getProductById(BigDecimal id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public void removeProduct(BigDecimal id) {

    }
}
