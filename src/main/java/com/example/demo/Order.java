package com.example.demo;

import java.util.List;

import com.example.demo.delivery.Delivery;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class Order {

    private List<Item> items;
    private Delivery  delivery;

    public Order(List<Item> items, Delivery delivery) {
        this.items = items;
        this.delivery = delivery;
    }

}
