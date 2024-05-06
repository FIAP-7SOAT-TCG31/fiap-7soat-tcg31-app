package com.aquiteturahexa.techchallenge.core.model;

public class Order {

    private Long id;
    private Long reqUser;
    private Long combos;
    private Float totalPrice;
    private Integer status;

    public Order() {
    }

    public Order(Long id, Long reqUser, Long combos, Float totalPrice, Integer status) {
        this.id = id;
        this.reqUser = reqUser;
        this.combos = combos;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReqUser() {
        return reqUser;
    }

    public void setReqUser(Long reqUser) {
        this.reqUser = reqUser;
    }

    public Long getCombos() {
        return combos;
    }

    public void setCombos(Long combos) {
        this.combos = combos;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}