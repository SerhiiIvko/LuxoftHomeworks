package com.luxoft.ivko.service.impl;

import com.luxoft.ivko.appProperties.ConstantsContainer;
import com.luxoft.ivko.dao.ProductDao;
import com.luxoft.ivko.dao.impl.ProductDaoDBImpl;
import com.luxoft.ivko.domain.Product;
import com.luxoft.ivko.exception.ValidationException;
import com.luxoft.ivko.service.ProductService;
import com.luxoft.ivko.validator.ProductValidatorService;
import com.luxoft.ivko.validator.impl.ProductValidatorImpl;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao = new ProductDaoDBImpl();
    private ProductValidatorService validator = new ProductValidatorImpl();

    @Override
    public Product createProduct(String name, String productType, String price) {
        if (!(validator.validateName(name)
                || validator.validateType(productType)
                || validator.validatePrice(price))) {
            throw new ValidationException(ConstantsContainer.VALIDATION_EXCEPTION_MESSAGE);
        } else {
            Product product = new Product(name, productType, price);
            boolean res = productDao.saveProduct(product);
            if (res) {
                System.out.println("Product created successfully! " + product.toString());
            }
            return product;
        }
    }

    @Override
    public void modifyProduct(Product product, String newName, String newPrice) {
        if (!(validator.validateName(newName)
                || validator.validatePrice(newPrice))) {
            throw new ValidationException(ConstantsContainer.VALIDATION_EXCEPTION_MESSAGE);
        } else {
            product.setName(newName);
            product.setPrice(newPrice);
            boolean res = productDao.updateProduct(product);
            if (res) {
                System.out.println("Product created successfully! " + product.toString());
            }
        }
    }

    @Override
    public void deleteProduct(Long id) {
        productDao.removeProduct(id);
    }
}
