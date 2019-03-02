package com.luxoft.ivko.validator.impl;

import com.luxoft.ivko.validator.ProductValidatorService;

public class ProductValidatorImpl implements ProductValidatorService {
    private final int maxInputDataLength = 28;

    @Override
    public boolean validateName(String name) {
        boolean correctName = !(name.trim().isEmpty() || name.length() > maxInputDataLength);
        if (!correctName) {
            System.out.println("incorrect product name " + name);
        }
        return correctName;
    }

    @Override
    public boolean validateType(String type) {
        boolean correctType = !(type.trim().isEmpty() || type.length() > maxInputDataLength);
        if (!correctType) {
            System.out.println("incorrect product type " + type);
        }
        return correctType;
    }

    @Override
    public boolean validatePrice(String priceString) {
        double price;
        boolean correctPrice;
        if (priceString.trim().isEmpty() || !priceString.matches("[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?")) {
            System.out.println("Price must be positive number!");
            return false;
        } else {
            price = Double.parseDouble(priceString);
            correctPrice = price > 0;
            if (!correctPrice) {
                System.out.println("Incorrect price " + priceString);
            }
        }
        return correctPrice;
    }
}
