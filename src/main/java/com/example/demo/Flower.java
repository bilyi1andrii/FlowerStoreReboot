package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Entity
public class Flower extends Item {
    @Id
    private String name;
    private String color;


    public Flower(String name, String color) {
        this.name = name;
        this.color = color;
    }
}
