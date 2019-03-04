package com.luxoft.ivko.dao;

public interface OrderDao {

    /**
     * Show created order by id
     *
     * @param id client's name
     */
    void getOrderById(Long id);

    /**
     * Pay created order by id
     *
     * @param id client's name
     */
    void payOrder(Long id, Long amount, Long sum);

    /**
     * Cancel created order by id
     *
     * @param id client's name
     */
    void cancelOrder(Long id);
}