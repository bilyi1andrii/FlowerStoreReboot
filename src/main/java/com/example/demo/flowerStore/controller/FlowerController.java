package com.example.demo.flowerStore.controller;

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


    @GetMapping
    public List<Item> getFlowers() {
        return List.of(
            new Flower(
            FlowerColor.RED,
            12,
            30.0,
            FlowerType.TULIP
            ),
            new Flower(
            FlowerColor.BLUE,
            7,
            60.0,
            FlowerType.ROSE
            ),
            new Flower(
            FlowerColor.WHITE,
            3,
            10.0,
            FlowerType.CHAMOMILE
            ),
            new Flower(
            FlowerColor.YELLOW,
            20,
            100.0,
            FlowerType.TULIP
            ),
            new Flower(
            FlowerColor.GREEN,
            12,
            77.0,
            FlowerType.ROSE
            ));
    }

}
