package com.luxoft.ivko.dao.impl;

import com.luxoft.ivko.dao.ProductDao;
import com.luxoft.ivko.domain.Product;

import java.math.BigDecimal;
import java.sql.*;
import java.util.List;

public class ProductDaoDBImpl implements ProductDao {
    private static final String PRODUCT_BY_ID_QUERY = "select * from product where id = '%s'";
    private static final String ALL_PRODUCTS_QUERY = "select * from product";
    private static final String ERROR_MESSAGE_PATTERN = "Product not found by %s: %s";
    private static final String INSERT_PRODUCT_QUERY = "insert into product (name, type, price) values (?, ?, ?)";
    private static final String UPDATE_PRODUCT_QUERY = "update product set name=?, type=?, price=? where id=?";
    private static final String DELETE_PRODUCT_QUERY = "delete from product where id=?";

    @Override
    public boolean saveProduct(Product product) {
        try (Connection connection = retrieveConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_PRODUCT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getProductType());
            statement.setDouble(3, product.getPrice());
//            isSaved = statement.execute();
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                product.setId(generatedKeys.getLong(1));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Failed to insert product into DB", e);
        }
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        try (Connection connection = retrieveConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT_QUERY)) {
            int parameterCounter = 1;
            statement.setString(parameterCounter++, product.getName());
            statement.setString(parameterCounter++, product.getProductType());
            statement.setDouble(parameterCounter++, product.getPrice());
            statement.setLong(parameterCounter, product.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException("Failed to update client", e);
        }
        return false;
    }

    @Override
    public Product getProductById(BigDecimal id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public void removeProduct(BigDecimal id) {

    }

    private Product getProductByQuery(String query, String errorMessage) {
        Product product = null;
        try (Connection connection = retrieveConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                product = new Product();
                product.setId(resultSet.getLong("id"));
                product.setName(resultSet.getString("name"));
                product.setProductType(resultSet.getString("productType"));
                product.setPrice(resultSet.getDouble("price"));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to load product from DB", e);
        }
        if (product == null) {
            throw new IllegalArgumentException(errorMessage);
        }
        return product;
    }

    private Connection retrieveConnection() throws SQLException {
        return DBManager.getConnection();
    }
}
