package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.flowerstore.model.Flower;
import com.example.demo.flowerstore.model.FlowerColor;
import com.example.demo.flowerstore.model.FlowerType;

import org.junit.jupiter.api.Assertions;

class FlowerTests {

    private static final FlowerColor TEST_COLOR = FlowerColor.RED;
    private static final int TEST_SEPAL_LENGTH = 10;
    private static final double TEST_PRICE = 29.99;
    private static final FlowerType TEST_TYPE = FlowerType.ROSE;

    private Flower flower;

    @BeforeEach
    void setup() {
        flower = new Flower(TEST_COLOR, TEST_SEPAL_LENGTH,
        TEST_PRICE, TEST_TYPE);
    }

    @Test
    void testGetColor() {
        Assertions.assertEquals(TEST_COLOR.toString(), flower.getColor());
    }

    @Test
    void testGetSepalLength() {
        Assertions.assertEquals(TEST_SEPAL_LENGTH, flower.getSepalLength());
    }

    @Test
    void testPrice() {
        Assertions.assertEquals(TEST_PRICE, flower.price());
    }

    @Test
    void testGetFlowerType() {
        Assertions.assertEquals(TEST_TYPE, flower.getFlowerType());
    }

    @Test
    void testCopyConstructor() {
        Flower copiedFlower = new Flower(flower);
        Assertions.assertEquals(flower.getColor(), copiedFlower.getColor());
        Assertions.assertEquals(flower.getSepalLength(),
        copiedFlower.getSepalLength());
        Assertions.assertEquals(flower.price(), copiedFlower.price());
        Assertions.assertEquals(flower.getFlowerType(),
        copiedFlower.getFlowerType());
    }
}