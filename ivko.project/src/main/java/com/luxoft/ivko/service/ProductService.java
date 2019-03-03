package com.luxoft.ivko.service;

import com.luxoft.ivko.domain.Product;

public interface ProductService {

    /**
     * Create new product in Service
     *
     * @param name        product name
     * @param price       product price
     * @param productType product type
     * @return new Product
     */
    Product createProduct(String name, Long price, String productType);

    /**
     * Modify product parameters
     *
     * @param product  product for modifying parameters
     * @param newName  new name for replace old name
     * @param newPrice new price for replace old price
     */
    void modifyProduct(Product product, String newName, Long newPrice);

    /**
     * Delete product
     *
     * @param id product id for correctly deleting
     */
    void deleteProduct(Long id);
}