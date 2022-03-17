package com.example.entity;

public class Employee {
    // properties // fields
    private String name;
    private int age;
    private int employeeID;

    //constructor :
    public Employee(String name, int age, int employeeID) {
        this.name = name;
        this.age = age;
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public String toString(){
        return "Employee [name = "+name+"";
    }
}
