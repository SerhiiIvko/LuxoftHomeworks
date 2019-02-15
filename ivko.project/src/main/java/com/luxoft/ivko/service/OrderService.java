package com.luxoft.ivko.service;

import java.math.BigDecimal;

public interface OrderService {

    /**
     * Show created order by id
     *
     * @param id client's name
     */
    void showOrderById(BigDecimal id);

    /**
     * Pay created order by id
     *
     * @param id client's name
     */
    void payOrder(BigDecimal id);

    /**
     * Cancel created order by id
     *
     * @param id client's name
     */
    void cancelOrder(BigDecimal id);
}