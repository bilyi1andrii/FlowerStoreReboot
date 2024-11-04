package com.example.demo.delivery;

import java.util.List;

import com.example.demo.flowerstore.model.Item;

public class PostDeliveryStrategy implements Delivery {

    @Override
    public String deliver(List<Item> items) {
        return "Delivered with Post";
    }
}
