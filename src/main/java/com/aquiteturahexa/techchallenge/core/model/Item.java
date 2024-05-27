package com.aquiteturahexa.techchallenge.core.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Item {

    private Long id;
    private String name;
    private ItemType type;
    private BigDecimal price;
    private Float quantity;
    private String description;
    private List<String> images;

    public Item() {
    }

    public Item(Long id, String name, ItemType type, BigDecimal price, Float quantity, String description,
            List<String> images) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.images = images;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getImages() {
        return new ArrayList<>(images);
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
