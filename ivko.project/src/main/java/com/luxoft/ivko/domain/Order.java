package com.luxoft.ivko.domain;

import java.util.List;

public class Order {
    private Long id;
    private Client client;
    private List<Product> productList;
    private double amount;
    private boolean isPaid;

    public Order(Client client, List<Product> productList) {
        this.client = client;
        this.productList = productList;
    }

    public Client getClient() {
        return client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public double getAmount() {
        double amount = 0;
        if (productList != null) {
            amount = productList.stream().mapToDouble(Product::getPrice).sum();
        }
        return amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client=" + client +
                ", productList=" + productList +
                ", amount=" + amount;
    }
}