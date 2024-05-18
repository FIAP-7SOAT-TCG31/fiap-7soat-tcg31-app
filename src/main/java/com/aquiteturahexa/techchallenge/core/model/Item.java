package com.aquiteturahexa.techchallenge.core.model;

import java.math.BigDecimal;

public class Item {

    private Long id;
    private String name;
    private ItemType type;
    private BigDecimal price;
    private Float quantity;

    public Item() {
    }

    public Item(Long id, String name, ItemType type, BigDecimal price, Float quantity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }
}
