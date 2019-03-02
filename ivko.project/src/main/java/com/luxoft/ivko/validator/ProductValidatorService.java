package com.luxoft.ivko.validator;

public interface ProductValidatorService {

    /**
     * Validate main product data
     *
     * @param name validation String product name
     */
    boolean validateName(String name);

    /**
     * Validate main product data
     *
     * @param type validation String product type
     */
    boolean validateType(String type);

    /**
     * Validate main product data
     *
     * @param price validation String product price
     */
    boolean validatePrice(String price);
}
