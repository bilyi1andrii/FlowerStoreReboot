package com.example.demo.delivery;

import java.util.List;

import com.example.demo.flowerstore.model.Item;

public interface Delivery {

    String deliver(List<Item> items);

}
