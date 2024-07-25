package com.cleanarchitecture.techchallenge.domain.factories;

import com.cleanarchitecture.techchallenge.domain.entities.item.Item;
import com.cleanarchitecture.techchallenge.domain.entities.item.ItemType;
import com.cleanarchitecture.techchallenge.domain.entities.payment.Payment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ItemFactory {

    private static ItemFactory instance;

    private ItemFactory() {
    }

    public static ItemFactory getInstance() {
        if (instance == null) {
            instance = new ItemFactory();
        }

        return instance;
    }

    public Item createItemWithIdNameTypePriceQuantityDescriptionImagesNote(Long id, String name, ItemType type, BigDecimal price, Float quantity, String description,
                                                                           List<String> images, String note) {
        return new Item(id, name, type, price, quantity, description, images, note);
    }

    public Item createItemWithIdNameTypePriceDescriptionImages(Long id, String name, ItemType type, BigDecimal price, String description,
                                                                           List<String> images) {
        return new Item(id, name, type, price, null, description, images, null);
    }


}
