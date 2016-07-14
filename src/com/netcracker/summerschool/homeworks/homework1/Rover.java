package com.netcracker.summerschool.homeworks.homework1;

/**
 * Created by somal on 14.07.16.
 */
public class Rover {
    private Direction direction;
    private int x, y;

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("Assignment is successful");
    }

    public void turnTo(Direction direction) {
        this.direction = direction;
        System.out.println("Assignment is successful");
    }
}
