package com.luxoft.ivko.domain;

import java.math.BigDecimal;
import java.util.List;

public class Order {
    private BigDecimal id;
    private Client client;
    private List<Product> productList;
    private double amount;

    public Order(Client client, List<Product> productList) {
        this.client = client;
        this.productList = productList;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client=" + client +
                ", productList=" + productList +
                '}';
    }
}