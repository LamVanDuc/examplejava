package com.example.exercise2;

public class MovablePoint implements Movable{
    private int x = 0;
    private int y = 0;
    public MovablePoint(){}



    public int getX(){
        return x;
    }public int getY(){
        return y;
    }
    @Override
    public void moveUp() {
        y++;
    }

    @Override
    public void moveDown() {
        y--;
    }

    @Override
    public void moveLeft() {
        x--;
    }

    @Override
    public void moveRight() {
        x++;
    }
}
