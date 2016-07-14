package com.netcracker.summerschool.homeworks.homework5;

import java.io.IOException;

/**
 * Created by somal on 14.07.16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Rover r = new Rover();
        r.getVisor().setGround(new Ground(10, 10));
        r.executeProgramFile("src/com/netcracker/summerschool/homeworks/homework5/command.xml");
        System.out.println(r);
    }
}
