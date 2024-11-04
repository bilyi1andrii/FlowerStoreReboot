package com.example.demo.flowerstore.model.decorators;

import com.example.demo.flowerstore.model.Item;

public class RibbonDecorator extends ItemDecorator{
    public RibbonDecorator(Item item) {
        super(item);
    }

    @Override
    public String getDescription() {
        return item.getDescription() + " in a ribbon wrapper!";
    }

    @Override
    public double price() {
        return 40 + item.price();
    }
}
