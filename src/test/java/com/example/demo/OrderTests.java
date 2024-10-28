package com.example.demo;

import com.example.demo.delivery.DHLDeliveryStrategy;
import com.example.demo.delivery.PostDeliveryStrategy;
import com.example.demo.payment.CreditCardPaymentStrategy;
import com.example.demo.payment.PayPalPaymentStrategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

class OrderTests {

    private static final double PRICE_ROSE = 30.0;
    private static final double PRICE_TULIP = 50.0;
    private static final int SEPAL_LENGTH_ROSE = 10;
    private static final int SEPAL_LENGTH_TULIP = 15;

    private Order order;
    private Flower redRose;
    private Flower blueTulip;

    @BeforeEach
    void setup() {
        redRose = new Flower(FlowerColor.RED,
        SEPAL_LENGTH_ROSE, PRICE_ROSE, FlowerType.ROSE);
        blueTulip = new Flower(FlowerColor.BLUE,
        SEPAL_LENGTH_TULIP, PRICE_TULIP, FlowerType.TULIP);

        List<Item> items = new ArrayList<>(List.of(redRose));
        order = new Order(items, new DHLDeliveryStrategy(),
        new CreditCardPaymentStrategy());
    }

    @Test
    void testCalculateTotalPrice() {
        double expectedTotal = PRICE_ROSE;
        Assertions.assertEquals(expectedTotal, order.calculateTotalPrice());

        order.addItem(blueTulip);
        expectedTotal += PRICE_TULIP;
        Assertions.assertEquals(expectedTotal, order.calculateTotalPrice());
    }

    @Test
    void testAddItem() {
        order.addItem(blueTulip);
        Assertions.assertEquals(2, order.getItems().size());
    }

    @Test
    void testRemoveItem() {
        order.addItem(blueTulip);
        order.removeItem(redRose);
        Assertions.assertEquals(1, order.getItems().size());
        Assertions.assertEquals(blueTulip, order.getItems().get(0));
    }

    @Test
    void testDeliveryAndPaymentStrategies() {
        String deliveryMessage = order.getDelivery()
        .deliver(order.getItems());
        Assertions.assertEquals("Delivered with DHL",
        deliveryMessage);

        String paymentMessage = order.getPayment()
        .pay(order.calculateTotalPrice());
        Assertions.assertEquals("Paid with credit card!",
        paymentMessage);
    }

    @Test
    void testPostDeliveryAndPayPalPaymentStrategies() {

        order = new Order(
                new ArrayList<>(List.of(redRose)),
                new PostDeliveryStrategy(),
                new PayPalPaymentStrategy()
        );

        String deliveryMessage = order
        .getDelivery().deliver(order.getItems());
        Assertions.assertEquals("Delivered with Post",
        deliveryMessage);

        String paymentMessage = order
        .getPayment().pay(order.calculateTotalPrice());
        Assertions.assertEquals("Paid with paypal!",
        paymentMessage);
    }
}