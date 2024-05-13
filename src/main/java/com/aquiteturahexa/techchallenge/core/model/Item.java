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

    public ItemType getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Float getQuantity() {
        return quantity;
    }
}
