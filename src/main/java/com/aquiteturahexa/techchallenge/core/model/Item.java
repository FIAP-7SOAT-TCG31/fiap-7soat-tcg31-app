package com.aquiteturahexa.techchallenge.core.model;

public class Item {

    private User id;
    private String name;
    private ItemType type;
    private Float price;
    private Float quantity;

    public Item() {

    }

    public Item(User id, String name, ItemType type, Float price, Float quantity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;

    }

    public User getId() {
        return id;
    }

    public void setId(User id) {
        this.id = id;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }
}
