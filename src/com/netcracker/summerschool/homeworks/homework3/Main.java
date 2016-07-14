package com.netcracker.summerschool.homeworks.homework3;

/**
 * Created by somal on 14.07.16.
 */
public class Main {
    public static void main(String[] args) {
        Rover r = new Rover();
        r.getVisor().setGround(new Ground(10, 10));
        r.move(5, 19);
    }
}
