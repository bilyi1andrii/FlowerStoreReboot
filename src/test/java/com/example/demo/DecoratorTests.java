package com.example.demo;

import com.example.demo.flowerstore.model.Flower;
import com.example.demo.flowerstore.model.FlowerColor;
import com.example.demo.flowerstore.model.FlowerType;
import com.example.demo.flowerstore.model.Item;
import com.example.demo.flowerstore.model.decorators.BasketDecorator;
import com.example.demo.flowerstore.model.decorators.PaperDecorator;
import com.example.demo.flowerstore.model.decorators.RibbonDecorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecoratorTests {

    private static final double BASKET_PRICE = 4.0;
    private static final double PAPER_PRICE = 13.0;
    private static final double RIBBON_PRICE = 40.0;
    private static final int DEFAULT_SEPAL_LENGTH = 10;

    @Test
    public void testFlowerWithBasketDecorator() {
        double basePrice = 15.99;
        Item flower = new Flower(FlowerColor.RED,
        DEFAULT_SEPAL_LENGTH, basePrice, FlowerType.ROSE);
        flower = new BasketDecorator(flower);

        assertEquals("Class: Flower of flowerstore in a basket wrapper!",
        flower.getDescription());

        assertEquals(basePrice + BASKET_PRICE,
        flower.price(), 0.01);
    }

    @Test
    public void testFlowerWithPaperDecorator() {
        double basePrice = 20.00;
        Item flower = new Flower(FlowerColor.BLUE,
        DEFAULT_SEPAL_LENGTH, basePrice, FlowerType.TULIP);
        flower = new PaperDecorator(flower);

        assertEquals("Class: Flower of flowerstore in a paper wrapper!",
        flower.getDescription());

        assertEquals(basePrice + PAPER_PRICE,
        flower.price(), 0.01);
    }

    @Test
    public void testFlowerWithRibbonDecorator() {
        double basePrice = 25.00;
        Item flower = new Flower(FlowerColor.YELLOW, DEFAULT_SEPAL_LENGTH,
        basePrice, FlowerType.CHAMOMILE);
        flower = new RibbonDecorator(flower);

        assertEquals("Class: Flower of flowerstore in a ribbon wrapper!",
        flower.getDescription());
        assertEquals(basePrice + RIBBON_PRICE,
        flower.price(), 0.01);
    }

    @Test
    public void testFlowerWithMultipleDecorators() {
        double basePrice = 10.00;
        Item flower = new Flower(FlowerColor.WHITE,
        DEFAULT_SEPAL_LENGTH, basePrice, FlowerType.ROSE);
        flower = new BasketDecorator(flower);
        flower = new PaperDecorator(flower);
        flower = new RibbonDecorator(flower);

        assertEquals("Class: Flower of flowerstore in a basket wrapper! "
        + "in a paper wrapper! in a ribbon wrapper!",
        flower.getDescription());
        assertEquals(basePrice + BASKET_PRICE + PAPER_PRICE + RIBBON_PRICE,
        flower.price(), 0.01);
    }
}