package com.example.demo.flowerStore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Flower;
import java.util.List;

@RestController
@RequestMapping("/api/flowers")
public class FlowerController {


    @GetMapping
    public List<Flower> getFlowers() {
        return null;
    }

}
