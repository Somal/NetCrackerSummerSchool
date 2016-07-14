package com.netcracker.summerschool.homeworks.homework5;

/**
 * Created by somal on 14.07.16.
 */
public class TurnCommand implements RoverCommand {
    private Turnable turnable;
    private Direction direction;

    public TurnCommand(Turnable turnable, Direction direction) {
        this.turnable = turnable;
        this.direction = direction;
    }

    @Override
    public void execute() {
        this.turnable.turnTo(direction);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
