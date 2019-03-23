package com.luxoft.ivko.validator;

import com.luxoft.ivko.web.dto.ProductCreateDto;

public interface ProductValidatorService {

    void validateProductData(String name, String productType, String price, boolean create);

    void validateProduct(ProductCreateDto createDto, boolean create);
//    /**
//     * Validate main product data
//     *
//     * @param name validation String product name
//     */
//    boolean validateName(String name);
//
//    /**
//     * Validate main product data
//     *
//     * @param type validation String product type
//     */
//    boolean validateType(String type);
//
//    /**
//     * Validate main product data
//     *
//     * @param price validation String product price
//     */
//    boolean validatePrice(String price);
}
