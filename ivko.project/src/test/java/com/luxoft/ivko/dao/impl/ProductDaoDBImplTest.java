package com.luxoft.ivko.dao.impl;

import com.luxoft.ivko.dao.ProductDao;
import com.luxoft.ivko.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductDaoDBImplTest {

    @Mock
    private DataSource dataSourceMock;

    @Mock
    private Connection connectionMock;

    @Mock
    private PreparedStatement preparedStatementMock;

    @Mock
    private ResultSet resultSetMock;

    @Mock
    private ProductDao productDao;

    private Product productMock;

    public ProductDaoDBImplTest() {
    }

    @Before
    public void setUp() throws Exception {
        when(dataSourceMock.getConnection()).thenReturn(connectionMock);
        when(connectionMock.prepareStatement(anyString())).thenReturn(preparedStatementMock);
        productMock = new Product();
        productMock.setId(1L);
        productMock.setName("Carrot");
        productMock.setProductType("Vegetable");
        productMock.setPrice("250");
        when(resultSetMock.first()).thenReturn(true);
        when(resultSetMock.getLong(1)).thenReturn(1L);
        when(resultSetMock.getString(2)).thenReturn(productMock.getName());
        when(resultSetMock.getString(3)).thenReturn(productMock.getProductType());
        when(resultSetMock.getString(4)).thenReturn(productMock.getPrice());
        when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);
    }

    @Test
    public void saveProduct() throws SQLException {

        when(productDao.saveProduct(productMock)).thenReturn(productMock);
    }

    @Test
    public void updateProduct() {

    }

    @Test
    public void getProductById() {

    }

    @Test
    public void getAllProducts() {

    }

    @Test
    public void removeProduct() {

    }
}