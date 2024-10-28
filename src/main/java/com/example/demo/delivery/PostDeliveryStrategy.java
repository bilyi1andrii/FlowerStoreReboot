package com.example.demo.delivery;

public class PostDeliveryStrategy implements Delivery {

    @Override
    public String getDeliveryNotification() {
        return "Delivered with Post";
    }
}
