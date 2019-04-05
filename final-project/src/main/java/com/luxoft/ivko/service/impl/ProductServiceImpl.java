package com.luxoft.ivko.service.impl;

import com.luxoft.ivko.converter.ProductConverter;
import com.luxoft.ivko.dao.ProductDao;
import com.luxoft.ivko.model.Product;
import com.luxoft.ivko.service.ProductService;
import com.luxoft.ivko.validator.ProductValidatorService;
import com.luxoft.ivko.web.dto.ProductCreateDto;
import com.luxoft.ivko.web.dto.ProductViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    @Qualifier("productDaoDBImpl")
    private ProductDao productDao;

    @Autowired
    private ProductValidatorService service;

    @Autowired
    private ProductConverter productConverter;

    public ProductServiceImpl() {
    }

    @Override
    @Transactional
    public ProductViewDto getProductById(long id) {
        Product product = productDao.getProductById(id);
        return productConverter.asProductDto(product);
    }

    @Override
    @Transactional
    public ProductViewDto registerProduct(ProductCreateDto createDto) {
        service.validateProduct(createDto, true);
        Product product = productConverter.asProduct(createDto);
        productDao.saveProduct(product);
        return productConverter.asProductDto(product);
    }

    @Override
    @Transactional
    public List<ProductViewDto> getAllProducts() {
        List<Product> products = productDao.getAllProducts();
        return products
                .stream()
                .map(product -> productConverter.asProductDto(product))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ProductViewDto updateProduct(ProductCreateDto createDto) {
        service.validateProduct(createDto, false);
        Product product = productConverter.asProduct(createDto);
        product = productDao.updateProduct(product);
        return productConverter.asProductDto(product);
    }

    @Override
    @Transactional
    public void updateProducts(List<ProductCreateDto> createDtoList) {
        createDtoList.forEach(productCreateDto -> service.validateProduct(productCreateDto, false));
        List<Product> products = createDtoList
                .stream()
                .map(productCreateDto -> productConverter.asProduct(productCreateDto))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteProduct(long id) {
        productDao.removeProduct(id);
    }
}
