package com.example.demo;

import com.example.demo.delivery.DHLDeliveryStrategy;
import com.example.demo.delivery.PostDeliveryStrategy;
import com.example.demo.payment.CreditCardPaymentStrategy;
import com.example.demo.payment.PayPalPaymentStrategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTests {

    private static final double FLOWER_PRICE1 = 30.0;
    private static final double FLOWER_PRICE2 = 50.0;
    private static final int SEPAL_LENGTH1 = 10;
    private static final int SEPAL_LENGTH2 = 15;

    private Order order;
    private Flower flower1;
    private Flower flower2;

    @BeforeEach
    void setup() {
        flower1 = new Flower(FlowerColor.RED, SEPAL_LENGTH1, FLOWER_PRICE1, FlowerType.ROSE);
        flower2 = new Flower(FlowerColor.BLUE, SEPAL_LENGTH2, FLOWER_PRICE2, FlowerType.TULIP);

        List<Item> items = new ArrayList<>(List.of(flower1));
        order = new Order(items, new DHLDeliveryStrategy(), new CreditCardPaymentStrategy());
    }

    @Test
    void testCalculateTotalPrice() {
        double expectedTotal = FLOWER_PRICE1;
        assertEquals(expectedTotal, order.calculateTotalPrice());

        // Add another flower and check total price
        order.addItem(flower2);
        expectedTotal += FLOWER_PRICE2;
        assertEquals(expectedTotal, order.calculateTotalPrice());
    }

    @Test
    void testAddItem() {
        order.addItem(flower2);
        assertEquals(2, order.getItems().size());
    }

    @Test
    void testRemoveItem() {
        order.addItem(flower2);
        order.removeItem(flower1);
        assertEquals(1, order.getItems().size());
        assertEquals(flower2, order.getItems().get(0));
    }

    @Test
    void testDeliveryAndPaymentStrategies() {
        String deliveryMessage = order.getDelivery().deliver(order.getItems());
        assertEquals("Delivered with DHL", deliveryMessage);

        String paymentMessage = order.getPayment().pay(order.calculateTotalPrice());
        assertEquals("Paid with credit card!", paymentMessage);
    }

    @Test
    void testPostDeliveryAndPayPalPaymentStrategies() {
        // Reinitialize order with PostDeliveryStrategy and PayPalPaymentStrategy
        order = new Order(new ArrayList<>(List.of(flower1)), new PostDeliveryStrategy(), new PayPalPaymentStrategy());

        String deliveryMessage = order.getDelivery().deliver(order.getItems());
        assertEquals("Delivered with Post", deliveryMessage);

        String paymentMessage = order.getPayment().pay(order.calculateTotalPrice());
        assertEquals("Paid with paypal!", paymentMessage);
    }
}