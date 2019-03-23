package com.luxoft.ivko.dao.impl;

import com.luxoft.ivko.dao.ProductDao;
import com.luxoft.ivko.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoDBImpl implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    public ProductDaoDBImpl() {
    }

    @Override
    public Product getProductById(Long id) {
        TypedQuery<Product> query = entityManager.createQuery(ProductConstants.PRODUCT_BY_ID, Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void saveProduct(Product entity) {
        entityManager.persist(entity);
    }

    @Override
    public Product updateProduct(Product entity) {
        return entityManager.merge(entity);
    }


    @PersistenceContext
    EntityManager em;

    private static final String PRODUCT_BY_ID_QUERY = "select * from product where id = '%s'";
    private static final String ALL_PRODUCTS_QUERY = "select * from product";
    private static final String ERROR_MESSAGE_PATTERN = "Product not found by %s: %s";
    private static final String INSERT_PRODUCT_QUERY = "insert into product (name, productType, price) values (?, ?, ?)";
    private static final String UPDATE_PRODUCT_QUERY = "update product set name=?, productType=?, price=? where id=?";
    private static final String DELETE_PRODUCT_QUERY = "delete from product where id=?";

    @Override
    public Product getProductById(Long id) {
        return getProductByQuery(String.format(PRODUCT_BY_ID_QUERY, id),
                String.format(ERROR_MESSAGE_PATTERN, "id", id));
    }

    @Override
    public Product saveProduct(Product product) {
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
            throw new IllegalArgumentException(e.getMessage());
        }
        return product;
    }

    @Override
    public Product updateProduct(Product product) {
        try (Connection connection = retrieveConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT_QUERY)) {
            int parameterCounter = 1;
            statement.setString(parameterCounter++, product.getName());
            statement.setString(parameterCounter++, product.getProductType());
            statement.setDouble(parameterCounter++, Double.parseDouble(product.getPrice()));
            statement.setLong(parameterCounter, product.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        return product;
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
            throw new IllegalArgumentException(e.getMessage());
        }
        return products;
    }


    public void removeProduct(Long id) {
        try (Connection connection = retrieveConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_QUERY)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public void update(List<Product> products){
        try (Connection connection = retrieveConnection();
             PreparedStatement statement = connection.prepareStatement(String.format(UPDATE_PRODUCT_QUERY, ""))) {
            for (Product product : products) {
                statement.setString(1, product.getName());
                statement.setString(2, product.getProductType());
                statement.setString(3, product.getPrice());
                statement.setLong(4, product.getId());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
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
            throw new IllegalArgumentException(e.getMessage());
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
