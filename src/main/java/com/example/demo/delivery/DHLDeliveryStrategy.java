package com.example.demo.delivery;

public class DHLDeliveryStrategy implements Delivery {

    @Override
    public String getDeliveryNotification() {
        return "Delivered with DHL";
    }



}
