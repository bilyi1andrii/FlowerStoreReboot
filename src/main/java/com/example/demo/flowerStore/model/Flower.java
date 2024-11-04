package com.example.demo.flowerstore.model;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Entity
public class Flower extends Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Enumerated(EnumType.STRING)
    private FlowerColor color;


    private int sepalLength;
    private double price;

    @Enumerated(EnumType.STRING)
    private FlowerType flowerType;

    public Flower(Flower flower) {
        color = flower.color;
        sepalLength = flower.sepalLength;
        price = flower.price;
        flowerType = flower.flowerType;
    }

    public Flower(FlowerColor color,
                int length,
                double price,
                FlowerType type) {

        this.color = color;
        this.sepalLength = length;
        this.price = price;
        this.flowerType = type;
    }

    public double price() {
        return this.price;
    }

    public String getColor() {
        return color.toString();
    }
}
