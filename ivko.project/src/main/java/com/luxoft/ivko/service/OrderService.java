package com.luxoft.ivko.service;

public interface OrderService {

    /**
     * Show created order by id
     *
     * @param id client's name
     */
    void showOrderById(Long id);

    /**
     * Pay created order by id
     *
     * @param id client's name
     */
    void payOrder(Long id);

    /**
     * Cancel created order by id
     *
     * @param id client's name
     */
    void cancelOrder(Long id);
}
