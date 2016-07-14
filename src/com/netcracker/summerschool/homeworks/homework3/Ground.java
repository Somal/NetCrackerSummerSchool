package com.netcracker.summerschool.homeworks.homework3;

/**
 * Created by somal on 14.07.16.
 */
public class Ground {
    private GroundCell[][] landscape;
    private int length, width;

    public Ground(int length, int width) {
        landscape = new GroundCell[width][length];
        for (int i = 0; i < width; i++)
            for (int j = 0; j < length; j++) {
                landscape[i][j] = new GroundCell(CellState.FREE, j, i);
            }
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
