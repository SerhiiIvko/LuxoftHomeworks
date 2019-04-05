package com.luxoft.ivko.appProperties;

public class ProductConstants {
    public static final String PRODUCT_BY_ID_QUERY = "select * from product where id = '%s'";
    public static final String ALL_PRODUCTS_QUERY = "select * from product";
    public static final String ERROR_MESSAGE_PATTERN = "Product not found by %s: %s";
    public static final String INSERT_PRODUCT_QUERY = "insert into product (name, productType, price) values (?, ?, ?)";
    public static final String UPDATE_PRODUCT_QUERY = "update product set name=?, productType=?, price=? where id=?";
    public static final String DELETE_PRODUCT_QUERY = "delete from product where id=?";

    public static final String FAILED_TO_LOAD_PRODUCT_FROM_DB = "Failed to load product from DB";
    public static final String FAILED_TO_INSERT_PRODUCT_INTO_DB = "Failed to insert product into DB";
    public static final String FAILED_TO_UPDATE_PRODUCT = "Failed to update product";
    public static final String FAILED_TO_DELETE_PRODUCT = "Failed to delete product";

}
