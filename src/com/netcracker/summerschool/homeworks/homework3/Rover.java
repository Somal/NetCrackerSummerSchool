package com.netcracker.summerschool.homeworks.homework3;

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
    }

    public void move(int x, int y) throws GroundVisorException {
        if (!this.visor.hasObstacles(x, y)) {
            this.x = x;
            this.y = y;
            System.out.println("Assignment is successful");
        } else System.out.println("Moving was stopped");
    }

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

    public RoverCommandParser getProgramParser() {
        return programParser;
    }

    public void setProgramParser(RoverCommandParser programParser) {
        this.programParser = programParser;
    }

    @Override
    public void executeProgramFile(String file) {

    }
}
