package com.luxoft.ivko.service;

import java.math.BigDecimal;

public interface OrderService {
    void showOrderById(BigDecimal id);
    void payOrder(BigDecimal id);
    void cancelOrder(BigDecimal id);
}