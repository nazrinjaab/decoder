package com.example.demo.entity;

public class Order {

    private Long id;
    private Long userId;
    private String productName;

    public Order() {
    }

    public Order(Long id, Long userId, String productName) {
        this.id = id;
        this.userId = userId;
        this.productName = productName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
