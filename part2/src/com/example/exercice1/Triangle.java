package com.example.exercice1;

public class Triangle extends Shape {

    private double base;
    private  double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        double Area = 0.5 * this.base * this.height;
        return Area;
    }

    @Override
    public String toString() {
        return "dien tich hinh tam giac: "+getArea();
    }
}
