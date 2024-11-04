package com.example.demo.flowerstore.model.decorators;

import com.example.demo.flowerstore.model.Item;

public class BasketDecorator extends ItemDecorator {
    public BasketDecorator(Item item) {
        super(item);
    }

    @Override
    public String getDescription() {
        return item.getDescription() + " in a basket wrapper!";
    }

    @Override
    public double price() {
        return 4 + item.price();
    }
}
