package com.luxoft.ivko.service;

import com.luxoft.ivko.domain.Product;

import java.math.BigDecimal;

public interface ProductService {

    /**
     * Create new product in Service
     *
     * @param name        product name
     * @param price       product price
     * @param productType product type
     * @return new Product
     */
    Product createProduct(String name, BigDecimal price, String productType);

    /**
     * Modify product parameters
     *
     * @param product  product for modifying parameters
     * @param newName  new name for replace old name
     * @param newPrice new price for replace old price
     */
    void modifyProduct(Product product, String newName, BigDecimal newPrice);

    /**
     * Delete product
     *
     * @param id product id for correctly deleting
     */
    void deleteProduct(BigDecimal id);
}