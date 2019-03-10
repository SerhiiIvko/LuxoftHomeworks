package com.luxoft.ivko.dao.impl;

import com.luxoft.ivko.dao.ProductDao;
import com.luxoft.ivko.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.sql.DataSource;
import java.sql.*;

import static org.junit.Assert.assertNotNull;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductDaoDBImplTest {

    @Mock
    private DataSource dataSourceMock;

    @Mock
    private DBManager dbManagerMock = mock(DBManager.class);

    @Mock
    private Connection connectionMock;

    @Mock
    private PreparedStatement preparedStatementMock;

    @Mock
    private ResultSet resultSetMock;

    @Mock
    private ProductDaoDBImpl productDao;

    private Product product;


    @Before
    public void setUp() throws Exception {
        when(new ProductDaoDBImpl()).thenReturn(productDao);
        when(DBManager.getConnection()).thenReturn(connectionMock);
        when(connectionMock.prepareStatement(any(String.class))).thenReturn(preparedStatementMock);
        System.out.println(connectionMock.toString());//product creation
        product = new Product();
        product.setId(1L);
        product.setName("Carrot");
        product.setProductType("Vegetable");
        product.setPrice("250");
        when(resultSetMock.first()).thenReturn(true);
        when(resultSetMock.getLong(1)).thenReturn(1L);
        when(resultSetMock.getString(2)).thenReturn(product.getName());
        when(resultSetMock.getString(3)).thenReturn(product.getProductType());
        when(resultSetMock.getString(4)).thenReturn(product.getPrice());
        when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);
        System.out.println(resultSetMock.toString());
    }

    @Test
    public void saveProduct() throws SQLException {
        new ProductDaoDBImpl().saveProduct(product);
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