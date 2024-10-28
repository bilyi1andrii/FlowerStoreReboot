package com.example.demo.flowerstore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Flower;
import com.example.demo.FlowerColor;
import com.example.demo.FlowerType;
import com.example.demo.Item;

import java.util.List;

@RestController
@RequestMapping("/api/flowers")
public class FlowerController {
    private static final int SEPAL_LENGTHM = 7;
    private static final int SEPAL_LENGTHB = 12;

    private static final double PRICE_MIN = 30;
    private static final double PRICE_MAX = 60;



    @GetMapping
    public List<Item> getFlowers() {
        return List.of(
            new Flower(
            FlowerColor.RED,
            SEPAL_LENGTHB,
            PRICE_MIN,
            FlowerType.TULIP
            ),
            new Flower(
            FlowerColor.BLUE,
            SEPAL_LENGTHM,
            PRICE_MAX,
            FlowerType.ROSE
            ));
    }

}
