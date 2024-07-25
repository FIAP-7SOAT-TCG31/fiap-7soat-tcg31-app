package com.cleanarchitecture.techchallenge.domain.entities.item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Item {

    private final Long id;
    private String name;
    private ItemType type;
    private BigDecimal price;
    private final Float quantity;
    private final String description;
    private final List<String> images;
    private final String note;

    public Item(Long id, String name, ItemType type, BigDecimal price, Float quantity, String description,
                List<String> images, String note) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.images = images;
        this.note = note;
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

    public String getDescription() {
        return description;
    }

    public List<String> getImages() {
        return images;
    }

    public String getNote() {
        return note;
    }

    public void update(Item item) {
        this.name = item.getName();
        this.type = item.getType();
        this.price = item.getPrice();
    }
}
