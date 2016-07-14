package com.netcracker.summerschool.homeworks.homework3;

import java.io.*;

/**
 * Created by somal on 14.07.16.
 */
public class Rover implements Moveable, Turnable, ProgramFileAware {
    private Direction direction;
    private int x, y;
    private GroundVisor visor;
    private RoverCommandParser programParser;

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
        BufferedReader in = new BufferedReader(new FileReader(file));
        this.programParser = new RoverCommandParser(this, in);

        RoverCommand command;
        while (true) {
            command = this.programParser.readNextCommand();
            if (command == null) break;
            command.execute();
        }

    }

    public GroundVisor getVisor() {
        return visor;
    }

    public void setVisor(GroundVisor visor) {
        this.visor = visor;
    }

    public RoverCommandParser getProgramParser() {
        return programParser;
    }

    public void setProgramParser(RoverCommandParser programParser) {
        this.programParser = programParser;
    }


}
