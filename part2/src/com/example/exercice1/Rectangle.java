package com.example.exercice1;

public class Rectangle extends Shape {
    private double length;
    public double width;
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
       double Area =  this.length * this.width;
        return Area;
    }



    @Override
    public String toString() {
        return "dien tich hinh chu nhat: "+getArea();
    }
}
