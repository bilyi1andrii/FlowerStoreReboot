package com.example.demo.flowerstore.model.decorators;

import com.example.demo.flowerstore.model.Item;

public abstract class ItemDecorator extends Item {
    protected Item item;

    public ItemDecorator(Item item) {
        this.item = item;
    }

    @Override
    public abstract String getDescription();
}
