package com.netcracker.summerschool.homeworks.homework3;

/**
 * Created by somal on 14.07.16.
 */
public class MoveCommand implements RoverCommand {
    private Moveable moveable;
    private int x, y;

    public MoveCommand(Moveable moveable, String[] args) {
        this.moveable = moveable;
        if (args.length != 2) throw new ArrayStoreException("Args must be string array with length 2");
        this.x = Integer.parseInt(args[0]);
        this.y = Integer.parseInt(args[1]);
    }

    @Override
    public void execute() {
        this.moveable.move(this.x, this.y);
    }
}
