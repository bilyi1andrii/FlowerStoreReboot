package com.example.demo.flowerstore;

import com.example.demo.flowerstore.model.Flower;
import com.example.demo.flowerstore.model.FlowerColor;
import com.example.demo.flowerstore.model.FlowerType;
import com.example.demo.flowerstore.model.Item;
import com.example.demo.flowerstore.model.decorators.BasketDecorator;
import com.example.demo.flowerstore.model.decorators.PaperDecorator;
import com.example.demo.flowerstore.model.decorators.RibbonDecorator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DecoratorTests {

    private static final double BASKET_PRICE = 4.0;
    private static final double PAPER_PRICE = 13.0;
    private static final double RIBBON_PRICE = 40.0;
    private static final int DEFAULT_SEPAL_LENGTH = 10;
    private static final double ASSERTION_TOLERANCE = 0.01;

    private static final double BASE_PRICE_BASKET_TEST = 15.99;
    private static final double BASE_PRICE_PAPER_TEST = 20.00;
    private static final double BASE_PRICE_RIBBON_TEST = 25.00;
    private static final double BASE_PRICE_MULTIPLE_DECORATORS_TEST = 10.00;

    @Test
    public void testFlowerWithBasketDecorator() {
        Item flower = new Flower(FlowerColor.RED, DEFAULT_SEPAL_LENGTH,
        BASE_PRICE_BASKET_TEST, FlowerType.ROSE);
        flower = new BasketDecorator(flower);

        Assertions.assertEquals("Class: Flower of flowerstore "
        + "in a basket wrapper!", flower.getDescription());
        Assertions.assertEquals(BASE_PRICE_BASKET_TEST + BASKET_PRICE,
        flower.price(), ASSERTION_TOLERANCE);
    }

    @Test
    public void testFlowerWithPaperDecorator() {
        Item flower = new Flower(FlowerColor.BLUE, DEFAULT_SEPAL_LENGTH,
        BASE_PRICE_PAPER_TEST, FlowerType.TULIP);
        flower = new PaperDecorator(flower);

        Assertions.assertEquals("Class: Flower of flowerstore "
        + "in a paper wrapper!", flower.getDescription());
        Assertions.assertEquals(BASE_PRICE_PAPER_TEST + PAPER_PRICE,
        flower.price(), ASSERTION_TOLERANCE);
    }

    @Test
    public void testFlowerWithRibbonDecorator() {
        Item flower = new Flower(FlowerColor.YELLOW, DEFAULT_SEPAL_LENGTH,
        BASE_PRICE_RIBBON_TEST, FlowerType.CHAMOMILE);
        flower = new RibbonDecorator(flower);

        Assertions.assertEquals("Class: Flower of flowerstore "
        + "in a ribbon wrapper!", flower.getDescription());
        Assertions.assertEquals(BASE_PRICE_RIBBON_TEST + RIBBON_PRICE,
        flower.price(), ASSERTION_TOLERANCE);
    }

    @Test
    public void testFlowerWithMultipleDecorators() {
        Item flower = new Flower(FlowerColor.WHITE, DEFAULT_SEPAL_LENGTH,
        BASE_PRICE_MULTIPLE_DECORATORS_TEST, FlowerType.ROSE);
        flower = new BasketDecorator(flower);
        flower = new PaperDecorator(flower);
        flower = new RibbonDecorator(flower);

        Assertions.assertEquals(
            "Class: Flower of flowerstore in a basket wrapper! "
            + "in a paper wrapper! in a ribbon wrapper!",
            flower.getDescription()
        );
        Assertions.assertEquals(BASE_PRICE_MULTIPLE_DECORATORS_TEST
        + BASKET_PRICE + PAPER_PRICE + RIBBON_PRICE,
        flower.price(), ASSERTION_TOLERANCE);
    }
}