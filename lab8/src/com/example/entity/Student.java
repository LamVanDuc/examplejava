package com.example.entity;

import java.util.Scanner;

public class Student {
    private int id;
    private  String firstName ;
    private  String lastName ;
    private double mark;

    public Student(){
    }

    public Student(int id, String firstName, String lastName, double mark) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public void ScanInfo(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter ID : ");
        this.id = input.nextInt();
        System.out.println("Enter first name : ");
        this.firstName = input.nextLine();
        System.out.println("Enter last name : ");
        this.lastName = input.nextLine();
        System.out.println("Enter mark: ");
        this.mark = input.nextDouble();

    }

    public void printInfo(){
        System.out.printf("%3d | %10s %10s |%5f",getId() , getFirstName() , getLastName() , getMark());

    }

}
