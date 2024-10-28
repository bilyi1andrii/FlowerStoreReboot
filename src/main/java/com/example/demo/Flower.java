package com.example.demo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Flower extends Item {
    private FlowerColor color;
    private int sepalLength;
    private double price;
    private FlowerType flowerType;

    public Flower(Flower flower) {
        color = flower.color;
        sepalLength = flower.sepalLength;
        price = flower.price;
        flowerType = flower.flowerType;
    }

    public double price() {
        return this.price;
    }

    public String getColor() {
        return color.toString();
    }
}
