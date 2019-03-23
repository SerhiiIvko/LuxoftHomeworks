package com.luxoft.ivko.dao;


import com.luxoft.ivko.model.Product;

import java.util.List;

public interface ProductDao {

    /**
     * Save product into storage
     *
     * @param product object product for saving as a data access object
     */
    Product saveProduct(Product product);

    /**
     * Modify product and update data in storage
     *
     * @param product object product for modifying as a data access object
     */
    Product updateProduct(Product product);

    /**
     * Get product from storage by id
     *
     * @param id product as object from storage
     */
    Product getProductById(Long id);

    /**
     * Get all clients from storage by email
     */
    List<Product> getAllProducts();

    /**
     * Remove client from storage by id
     *
     * @param id client's id for correctly removing
     */
    void removeProduct(Long id);


    void update(List<Product> products);
}