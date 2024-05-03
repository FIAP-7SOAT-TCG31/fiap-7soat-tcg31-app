package com.aquiteturahexa.techchallenge.core.model;

import java.util.List;

public class Order {

    private Long id;
    private User reqUser;
    private List<Combo> combos;
    private Float totalPrice;
    private Status status;

    public Order() {
    }

    public Order(Long id, User reqUser, List<Combo> combos, Float totalPrice, Status status) {
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

    public User getReqUser() {
        return reqUser;
    }

    public void setReqUser(User reqUser) {
        this.reqUser = reqUser;
    }

    public List<Combo> getCombos() {
        return combos;
    }

    public void setCombos(List<Combo> combos) {
        this.combos = combos;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
