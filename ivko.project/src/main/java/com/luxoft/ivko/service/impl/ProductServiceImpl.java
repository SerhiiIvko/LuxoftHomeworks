package com.luxoft.ivko.service.impl;

import com.luxoft.ivko.converter.ProductConverter;
import com.luxoft.ivko.dao.ProductDao;
import com.luxoft.ivko.dao.impl.ProductDaoDBImpl;
import com.luxoft.ivko.domain.Product;
import com.luxoft.ivko.service.ProductService;
import com.luxoft.ivko.validator.ProductValidatorService;
import com.luxoft.ivko.validator.impl.ProductValidatorImpl;
import com.luxoft.ivko.web.dto.ProductCreateDto;
import com.luxoft.ivko.web.dto.ProductViewDto;

import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao = new ProductDaoDBImpl();
    private ProductValidatorService service = new ProductValidatorImpl();
    private ProductConverter productConverter = new ProductConverter();

    @Override
    public ProductViewDto getProductById(long id) {
        Product product = productDao.getProductById(id);
        return productConverter.asProductDto(product);
    }

    @Override
    public ProductViewDto registerProduct(ProductCreateDto createDto) {
        service.validateProduct(createDto, true);
        Product product = productConverter.asProduct(createDto);
        product = productDao.saveProduct(product);
        return productConverter.asProductDto(product);
    }

    @Override
    public List<ProductViewDto> getAllProducts() {
        List<Product> products = productDao.getAllProducts();
        return products
                .stream()
                .map(product -> productConverter.asProductDto(product))
                .collect(Collectors.toList());
    }

    @Override
    public ProductViewDto updateProduct(ProductCreateDto createDto) {
        service.validateProduct(createDto, false);
        Product product = productConverter.asProduct(createDto);
        product = productDao.updateProduct(product);
        return productConverter.asProductDto(product);
    }

    @Override
    public void updateProducts(List<ProductCreateDto> createDtoList) {
        createDtoList.forEach(productCreateDto -> service.validateProduct(productCreateDto, false));
        List<Product> products = createDtoList
                .stream()
                .map(productCreateDto -> productConverter.asProduct(productCreateDto))
                .collect(Collectors.toList());
        productDao.update(products);
    }

    @Override
    public void deleteProduct(ProductCreateDto createDto) {
        Product product = productConverter.asProduct(createDto);
        productDao.removeProduct(product.getId());
    }
}
