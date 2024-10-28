package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class FlowerBucket extends Item {
    private List<FlowerPack> flowerPacks;

    public FlowerBucket() {
        flowerPacks = new ArrayList<>();
    }

    public void addFlowerPack(FlowerPack flowerPack) {
        flowerPacks.add(flowerPack);
    }

    public double price() {
        double price = 0;
        for (FlowerPack flowerPack: flowerPacks) {
            price += flowerPack.getPrice();
        }
        return price;
    }

    public List<FlowerPack> getFlowerPacks() {
        return flowerPacks;
    }
}