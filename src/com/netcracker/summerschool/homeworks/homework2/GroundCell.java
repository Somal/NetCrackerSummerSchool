package com.netcracker.summerschool.homeworks.homework2;

/**
 * Created by somal on 14.07.16.
 */
public class GroundCell {
    private CellState state;
    private int x, y;

    public GroundCell(CellState state, int x, int y) {
        this.state = state;
        this.x = x;
        this.y = y;
    }

    public void setState(CellState state) {
        this.state = state;
    }

    public CellState getState() {
        return state;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

}
