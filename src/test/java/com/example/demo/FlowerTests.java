package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlowerTests {

    private static final FlowerColor TEST_COLOR = FlowerColor.RED;
    private static final int TEST_SEPAL_LENGTH = 10;
    private static final double TEST_PRICE = 29.99;
    private static final FlowerType TEST_TYPE = FlowerType.ROSE;

    private Flower flower;

    @BeforeEach
    void setup() {
        flower = new Flower(TEST_COLOR, TEST_SEPAL_LENGTH, TEST_PRICE, TEST_TYPE);
    }

    @Test
    void testGetColor() {
        assertEquals(TEST_COLOR.toString(), flower.getColor());
    }

    @Test
    void testGetSepalLength() {
        assertEquals(TEST_SEPAL_LENGTH, flower.getSepalLength());
    }

    @Test
    void testPrice() {
        assertEquals(TEST_PRICE, flower.price());
    }

    @Test
    void testGetFlowerType() {
        assertEquals(TEST_TYPE, flower.getFlowerType());
    }

    @Test
    void testCopyConstructor() {
        Flower copiedFlower = new Flower(flower);
        assertEquals(flower.getColor(), copiedFlower.getColor());
        assertEquals(flower.getSepalLength(), copiedFlower.getSepalLength());
        assertEquals(flower.price(), copiedFlower.price());
        assertEquals(flower.getFlowerType(), copiedFlower.getFlowerType());
    }
}