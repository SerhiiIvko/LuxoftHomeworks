package com.luxoft.ivko.validator;

import com.luxoft.ivko.web.dto.ProductCreateDto;

public interface ProductValidatorService {

    /**
     * Validate main product data
     *
     * @param name        validation String product name
     * @param productType validation String product type
     * @param price       validation String product price
     * @param create      validation condition product create
     */
    void validateProductData(String name, String productType, String price, boolean create);

    /**
     * Validate main product data
     *
     * @param createDto validation ProductCreateDto object
     * @param create    validation condition object create
     */
    void validateProduct(ProductCreateDto createDto, boolean create);
}
