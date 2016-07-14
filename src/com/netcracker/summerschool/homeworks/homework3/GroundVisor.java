package com.netcracker.summerschool.homeworks.homework3;

/**
 * Created by somal on 14.07.16.
 */
public class GroundVisor {
    private Ground ground;

    public boolean hasObstacles(int x, int y) throws GroundVisorException {
        if (x < 0 || y < 0)
            throw new GroundVisorException();
        if (x >= this.ground.getWidth() || y >= this.ground.getLength())
            throw new GroundVisorException();
        return false;
    }

    public void setGround(Ground ground) {
        this.ground = ground;
    }

    public Ground getGround() {
        return this.ground;
    }
}
