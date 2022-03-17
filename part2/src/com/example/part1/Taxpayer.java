package com.example.part1;

public abstract class Taxpayer {
    public String id;
    public String getId(){
        return this.id;
    }

    public abstract double pay();
}
