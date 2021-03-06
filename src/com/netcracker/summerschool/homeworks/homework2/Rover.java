package com.netcracker.summerschool.homeworks.homework2;

/**
 * Created by somal on 14.07.16.
 */
public class Rover implements Moveable, Turnable{
    private Direction direction;
    private int x, y;
    private GroundVisor visor;

    public Rover() {
        this.visor = new GroundVisor();
    }

    @Override
    public void move(int x, int y) throws GroundVisorException{
        if (!this.visor.hasObstacles(x, y)) {
            this.x = x;
            this.y = y;
            System.out.println("Assignment is successful");
        } else System.out.println("Moving was stopped");
    }

    @Override
    public void turnTo(Direction direction) {
        this.direction = direction;
        System.out.println("Assignment is successful");
    }

    public GroundVisor getVisor() {
        return visor;
    }

    public void setVisor(GroundVisor visor) {
        this.visor = visor;
    }

}
