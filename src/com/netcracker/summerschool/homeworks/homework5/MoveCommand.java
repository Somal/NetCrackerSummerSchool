package com.netcracker.summerschool.homeworks.homework5;

/**
 * Created by somal on 14.07.16.
 */
public class MoveCommand implements RoverCommand {
    private Moveable moveable;
    private int x, y;

    public MoveCommand(Moveable moveable, int x, int y) {
        this.moveable = moveable;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        this.moveable.move(this.x, this.y);
    }

    @Override
    public String toString() {
        return "Move command";
    }
}
