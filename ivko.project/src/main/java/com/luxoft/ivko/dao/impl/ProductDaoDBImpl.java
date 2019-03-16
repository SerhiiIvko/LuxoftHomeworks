package com.luxoft.ivko.dao.impl;

import com.luxoft.ivko.appProperties.AdminMenuConstants;
import com.luxoft.ivko.dao.ProductDao;
import com.luxoft.ivko.domain.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoDBImpl implements ProductDao {
    private static final String PRODUCT_BY_ID_QUERY = "select * from product where id = '%s'";
    private static final String ALL_PRODUCTS_QUERY = "select * from product";
    private static final String ERROR_MESSAGE_PATTERN = "Product not found by %s: %s";
    private static final String INSERT_PRODUCT_QUERY = "insert into product (name, productType, price) values (?, ?, ?)";
    private static final String UPDATE_PRODUCT_QUERY = "update product set name=?, productType=?, price=? where id=?";
    private static final String DELETE_PRODUCT_QUERY = "delete from product where id=?";

    @Override
    public boolean saveProduct(Product product) {
        try (Connection connection = retrieveConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_PRODUCT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getProductType());
            statement.setDouble(3, Double.parseDouble(product.getPrice()));
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                product.setId(generatedKeys.getLong(1));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(AdminMenuConstants.FAILED_TO_INSERT_PRODUCT_INTO_DB, e);
        }
        return true;
    }

    @Override
    public boolean updateProduct(Product product) {
        try (Connection connection = retrieveConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT_QUERY)) {
            int parameterCounter = 1;
            statement.setString(parameterCounter++, product.getName());
            statement.setString(parameterCounter++, product.getProductType());
            statement.setDouble(parameterCounter++, Double.parseDouble(product.getPrice()));
            statement.setLong(parameterCounter, product.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(AdminMenuConstants.FAILED_TO_UPDATE_PRODUCT, e);
        }
        return false;
    }

    @Override
    public Product getProductById(Long id) {
        return getProductByQuery(String.format(PRODUCT_BY_ID_QUERY, id),
                String.format(ERROR_MESSAGE_PATTERN, "id", id));
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = retrieveConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(ALL_PRODUCTS_QUERY);
            while (resultSet.next()) {
                Product product = new Product();
                setData(resultSet, product);
                products.add(product);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(AdminMenuConstants.FAILED_TO_LOAD_PRODUCT_FROM_DB, e);
        }
        return products;
    }

    @Override
    public void removeProduct(Long id) {
        try (Connection connection = retrieveConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_QUERY)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(AdminMenuConstants.FAILED_TO_DELETE_PRODUCT, e);
        }
    }

    private Product getProductByQuery(String query, String errorMessage) {
        Product product = null;
        try (Connection connection = retrieveConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                product = new Product();
                setData(resultSet, product);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(AdminMenuConstants.FAILED_TO_LOAD_PRODUCT_FROM_DB, e);
        }
        if (product == null) {
            throw new IllegalArgumentException(errorMessage);
        }
        return product;
    }

    private Connection retrieveConnection() throws SQLException {
        return DBManager.getConnection();
    }

    private void setData(ResultSet resultSet, Product product) throws SQLException {
        product.setId(resultSet.getLong("id"));
        product.setName(resultSet.getString("name"));
        product.setProductType(resultSet.getString("productType"));
        product.setPrice(resultSet.getString("price"));
    }
}
