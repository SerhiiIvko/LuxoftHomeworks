package com.luxoft.ivko.service;

import com.luxoft.ivko.web.dto.ProductCreateDto;
import com.luxoft.ivko.web.dto.ProductViewDto;

import java.util.List;

public interface ProductService {

//    /**
//     * Create new product in Service
//     *
//     * @param name        product name
//     * @param price       product price
//     * @param productType product type
//     * @return new Product
//     */
//    void createProduct(String name, String productType, String price);
//
//    /**
//     * Modify product parameters
//     *
//     * @param product  product for modifying parameters
//     * @param newName  new name for replace old name
//     * @param newPrice new price for replace old price
//     */
//    void modifyProduct(Product product, String newName, String newPrice);
//
//    /**
//     * Delete product
//     *
//     * @param id product id for correctly deleting
//     */
//    void deleteProduct(Long id);

    ProductViewDto registerProduct(ProductCreateDto createDto);

    List<ProductViewDto> getAllProducts();

    ProductViewDto getProductById(long id);

    ProductViewDto updateProduct(ProductCreateDto createDto);

    void updateProducts(List<ProductCreateDto> createDtoList);

    void deleteProduct(ProductCreateDto createDto);
}
