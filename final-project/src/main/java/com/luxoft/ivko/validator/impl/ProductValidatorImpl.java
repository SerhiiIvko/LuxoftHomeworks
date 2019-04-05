package com.luxoft.ivko.validator.impl;

import com.luxoft.ivko.appProperties.ConstantsContainer;
import com.luxoft.ivko.exception.ValidationException;
import com.luxoft.ivko.validator.ProductValidatorService;
import com.luxoft.ivko.web.dto.ProductCreateDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

@Repository
public class ProductValidatorImpl implements ProductValidatorService {

    @Override
    public void validateProductData(String name, String productType, String price, boolean create) {
        if (!(validateName(name) || validatePrice(price) || validateType(productType))) {
            throw new ValidationException("Invalid data!");
        }
    }

    @Override
    public void validateProduct(ProductCreateDto createDto, boolean create) {
        validateProductData(createDto.getName(), createDto.getProductType(), createDto.getPrice(), create);
        if (StringUtils.isEmpty(createDto.getName())) {
            throw new ValidationException("Invalid product name: " + createDto.getName());
        }
    }

    private static boolean validateName(String name) {
        boolean correctName = !(name.trim().isEmpty() || name.length() > ConstantsContainer.MAX_INPUT_DATA_LENGTH);
        if (!correctName) {
            System.out.println("incorrect product name " + name);
        }
        return correctName;
    }

    private static boolean validateType(String type) {
        boolean correctType = !(type.trim().isEmpty() || type.length() > ConstantsContainer.MAX_INPUT_DATA_LENGTH);
        if (!correctType) {
            System.out.println("incorrect product type " + type);
        }
        return correctType;
    }

    private static boolean validatePrice(String priceString) {
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
