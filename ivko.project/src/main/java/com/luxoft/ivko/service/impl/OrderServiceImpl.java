package com.luxoft.ivko.service.impl;

import com.luxoft.ivko.dao.OrderDao;
import com.luxoft.ivko.dao.impl.OrderDaoDBImpl;
import com.luxoft.ivko.service.OrderService;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoDBImpl();

    @Override
    public void showOrderById(Long id) {

    }

    @Override
    public void payOrder(Long id) {

    }

    @Override
    public void cancelOrder(Long id) {

    }
}
