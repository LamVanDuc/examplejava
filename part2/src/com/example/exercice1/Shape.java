package com.example.exercice1;

public abstract class Shape {
    private String color;

    public String getColor(){
        return this.color;
    }

    public abstract double getArea();

    public abstract String toString();
}
