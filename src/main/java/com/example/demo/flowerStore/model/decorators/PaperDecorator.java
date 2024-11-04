package com.example.demo.flowerstore.model.decorators;

import com.example.demo.flowerstore.model.Item;

public class PaperDecorator extends ItemDecorator {

    public PaperDecorator(Item item) {
        super(item);
    }

    @Override
    public String getDescription() {
        return item.getDescription() + " in a paper wrapper!";
    }

    @Override
    public double price() {
        return 13 + item.price();
    }
}
