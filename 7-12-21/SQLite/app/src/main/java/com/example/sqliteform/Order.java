package com.example.sqliteform;

public class Order {
    private String userOrder;
    private String userAdd;
    private String userPhNo;

    public Order() {
    }

    public Order(String userOrder, String userAdd, String userPhNo) {
        this.userOrder = userOrder;
        this.userAdd = userAdd;
        this.userPhNo = userPhNo;
    }

    public String getUserOrder() {
        return userOrder;
    }

    public String getUserAdd() {
        return userAdd;
    }

    public String getUserPhNo() {
        return userPhNo;
    }

    public void setUserOrder() {
        this.userOrder = userOrder;
    }

    public void setUserAdd() {
        this.userAdd = userAdd;
    }

    public void setUserPhNo() {
        this.userPhNo = userPhNo;
    }
}
