package com.example.demo.flowerstore.model.decorators;

import com.example.demo.flowerstore.model.Item;

public class PaperDecorator extends ItemDecorator {
    private static final int OFFPRICE = 13;

    public PaperDecorator(Item item) {
        super(item);
    }

    @Override
    public String getDescription() {
        return getItem().getDescription() + " in a paper wrapper!";
    }

    @Override
    public double price() {
        return OFFPRICE + getItem().price();
    }
}
