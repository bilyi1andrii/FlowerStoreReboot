package com.example.demo.flowerstore.model;

import java.util.List;

import com.example.demo.delivery.Delivery;
import com.example.demo.payment.Payment;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class Order {

    private List<Item> items;
    private Delivery  delivery;
    private Payment payment;

    public Order(List<Item> items, Delivery delivery, Payment payment) {
        this.items = items;
        this.delivery = delivery;
        this.payment = payment;
    }


    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Item item: items) {
            totalPrice += item.price();
        }
        return totalPrice;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

}
