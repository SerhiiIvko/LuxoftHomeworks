package com.luxoft.ivko.service.impl;

import com.luxoft.ivko.dao.ProductDao;
import com.luxoft.ivko.dao.impl.ProductDaoDBImpl;
import com.luxoft.ivko.domain.Product;
import com.luxoft.ivko.service.ProductService;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao = new ProductDaoDBImpl();

    @Override
    public Product createProduct(String name, Long price, String productType) {
        return null;
    }

    @Override
    public void modifyProduct(Product product, String newName, Long newPrice) {

    }

    @Override
    public void deleteProduct(Long id) {

    }
}
