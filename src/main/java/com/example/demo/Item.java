package com.example.demo;


public abstract class Item {

    private String description = "Class: "
    + this.getClass().getSimpleName()
    + " of flowerstore";

    public String getDescription() {
        return this.description;
    }

    abstract double price();

}
