package com.example.demo.flowerstore.model.decorators;

import com.example.demo.flowerstore.model.Item;

import lombok.Getter;

@Getter
public abstract class ItemDecorator extends Item {
    private Item item;

    public ItemDecorator(Item item) {
        this.item = item;
    }

    protected Item getItem() {
        return this.item;
    }

    @Override
    public abstract String getDescription();
}
