package com.example.exercise2;

public class MoveMain {
    public static void main(String[] args){
        MovablePoint movablePoint = new MovablePoint();
        for (int i= 0 ; i<= 10;i++){
            movablePoint.moveUp();
            movablePoint.moveLeft();
        }
        System.out.println(movablePoint.getX()+" : "+movablePoint.getY());

    }
}
