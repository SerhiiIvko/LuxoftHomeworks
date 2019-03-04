package com.luxoft.ivko.dao.impl;

import com.luxoft.ivko.dao.ClientDao;
import com.luxoft.ivko.dao.OrderDao;
import com.luxoft.ivko.dao.ProductDao;

public class OrderDaoDBImpl implements OrderDao {
    private static final String ORDER_BY_ID_QUERY = "select * from order where id = '%s'";
    private static final String ERROR_MESSAGE_PATTERN = "Order not found by %s: %s";
    private static final String INSERT_PRODUCT_QUERY = "insert into order (name, type, price) values (?, ?, ?)";
    private static final String UPDATE_PRODUCT_QUERY = "update order set name=?, type=?, price=? where id=?";
    private static final String DELETE_PRODUCT_QUERY = "delete from product where id=?";
    private ClientDao clientDao;
    private ProductDao productDao;

    @Override
    public void getOrderById(Long id) {

    }

    @Override
    public void payOrder(Long id, Long amount, Long sum) {

    }

    @Override
    public void cancelOrder(Long id) {

    }
}
