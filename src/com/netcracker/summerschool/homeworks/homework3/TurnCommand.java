package com.netcracker.summerschool.homeworks.homework3;

import com.netcracker.summerschool.homeworks.homework3.Direction;

/**
 * Created by somal on 14.07.16.
 */
public class TurnCommand implements RoverCommand {
    private Turnable turnable;
    private String command;

    public TurnCommand(Turnable turnable, String[] args) {
        this.turnable = turnable;

        if (args.length > 1 || args.length == 0)
            throw new ArrayStoreException("Args must be string array with length 1");
        this.command = args[0];
    }

    @Override
    public void execute() {
        this.turnable.turnTo(Direction.valueOf(command));
    }
}
