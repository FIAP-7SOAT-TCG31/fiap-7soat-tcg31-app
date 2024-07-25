package com.cleanarchitecture.techchallenge.domain.entities.item;

import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Combo {

    private List<Item> items;

    public Combo(List<Item> items) {
        this.items = items;
    }

    public void add(Item item) {
        if (CollectionUtils.isEmpty(this.items)) {
            this.items = new ArrayList<>();
        }

        this.items.add(item);
    }

    public void remove(Item item) {
        if (CollectionUtils.isEmpty(this.items)) {
            return;
        }

        this.items
                .removeIf(comboItem -> comboItem.getName().equalsIgnoreCase(item.getName())
                        && comboItem.getType() == item.getType());
    }

    public BigDecimal calculate() {
        if (CollectionUtils.isEmpty(this.items)) {
            return BigDecimal.ZERO;
        }

        return this
                .items
                .stream()
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<Item> getItems() {
        return items;
    }
}
