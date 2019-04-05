package com.luxoft.ivko.service;

import com.luxoft.ivko.web.dto.ProductCreateDto;
import com.luxoft.ivko.web.dto.ProductViewDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    /**
     * Register new product in Service
     *
     * @param createDto object ProductCreateDto for creation
     */
    ProductViewDto registerProduct(ProductCreateDto createDto);

    /**
     * Get all products
     * <p>
     * return all products from storage
     */
    List<ProductViewDto> getAllProducts();

    /**
     * Get product by id
     *
     * @param id product's id for return from storage
     */
    ProductViewDto getProductById(long id);

    /**
     * Modify product parameters
     *
     * @param createDto object ProductCreateDto for modifying parameters
     */
    ProductViewDto updateProduct(ProductCreateDto createDto);

    /**
     * Update all products
     * <p>
     * return all products from storage for transfer it's on view
     */
    void updateProducts(List<ProductCreateDto> createDtoList);

    /**
     * Delete product
     *
     * @param id id of product for correctly deleting
     */
    void deleteProduct(long id);
}
