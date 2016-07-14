package com.netcracker.summerschool.homeworks.homework5;

import java.io.IOException;

/**
 * Created by somal on 14.07.16.
 */
public class Rover implements Moveable, Turnable, ProgramFileAware {
    private Direction direction;
    private int x, y;
    private GroundVisor visor;
    private TextRoverCommandParser programParser;

    public Rover() {
        this.visor = new GroundVisor();
        this.x = 0;
        this.y = 0;
    }

    @Override
    public void move(int x, int y) throws GroundVisorException {
        if (!this.visor.hasObstacles(x, y)) {
            this.x = x;
            this.y = y;
            System.out.println("Moved to " + x + " " + y);
        } else System.out.println("Moving was stopped");
    }

    @Override
    public void turnTo(Direction direction) {
        this.direction = direction;
        System.out.println("Turned to " + direction.name());
    }

    @Override
    public void executeProgramFile(String file) throws IOException {
        RoverCommand roverCommand = new ImportCommand(this, file);
        roverCommand.execute();
    }

    public GroundVisor getVisor() {
        return visor;
    }

    public void setVisor(GroundVisor visor) {
        this.visor = visor;
    }

    public TextRoverCommandParser getProgramParser() {
        return programParser;
    }

    public void setProgramParser(TextRoverCommandParser programParser) {
        this.programParser = programParser;
    }

    @Override
    public String toString() {
        return "Coordinates: " + this.x + " " + this.y + "; Direction: " + this.direction;
    }
}
