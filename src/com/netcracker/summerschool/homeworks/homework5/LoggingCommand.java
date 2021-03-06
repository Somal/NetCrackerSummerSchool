package com.netcracker.summerschool.homeworks.homework5;

/**
 * Created by somal on 14.07.16.
 */
public class LoggingCommand implements RoverCommand {
    private RoverCommand command;

    public LoggingCommand(RoverCommand roverCommand) {
        this.command = roverCommand;
    }

    @Override
    public void execute() {
        this.command.execute();
        System.out.println(this.command);
    }
}
