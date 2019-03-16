package com.luxoft.ivko.converter;

import com.luxoft.ivko.domain.Product;
import com.luxoft.ivko.web.dto.ProductCreateDto;
import com.luxoft.ivko.web.dto.ProductViewDto;

public class ProductConverter {

    public ProductViewDto asProductDto(Product product) {
        ProductViewDto dto = new ProductViewDto();
        setData(product, dto);
        return dto;
    }

    public Product asProduct(ProductCreateDto createDto) {
        Product product = new Product();
        product.setId(createDto.getId());
        product.setName(createDto.getName());
        product.setPrice(createDto.getPrice());
        product.setProductType(createDto.getProductType());
        return product;
    }

    private void setData(Product product, ProductViewDto dto) {
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setProductType(product.getProductType());
    }
}
