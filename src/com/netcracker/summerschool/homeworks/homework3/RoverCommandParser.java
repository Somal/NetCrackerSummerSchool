package com.netcracker.summerschool.homeworks.homework3;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by somal on 14.07.16.
 */
public class RoverCommandParser {
    private Rover rover;
    private BufferedReader in;

    public RoverCommandParser(Rover rover, BufferedReader in) {
        this.rover = rover;
        this.in = in;
    }

    public RoverCommand readNextCommand() throws IOException, ValueException {
        String commandLine = in.readLine();
        if (commandLine == null) return null;
        if (!checkWithRegExp(commandLine))
            throw new ValueException("Method is a string like moveTo(args) or turnTo(args)");
        String[] splitted = commandLine.split("\\(");
        String command = splitted[0];
        String[] args = splitted[1].split("\\)")[0].split(",");

        RoverCommand roverCommand;
        switch (command) {
            case "moveTo":
                roverCommand = new MoveCommand(this.rover, args);
                break;
            case "turnTo":
                roverCommand = new TurnCommand(this.rover, args);
                break;
            default:
                throw new ValueException("Method is a string like moveTo(args) or turnTo(args)");
        }

        return roverCommand;
    }

    private static boolean checkWithRegExp(String userNameString) {
        Pattern p = Pattern.compile("^[a-zA-z]+\\(([a-zA-Z0-9]+\\,?)+\\)$");
        Matcher m = p.matcher(userNameString);
        return m.matches();
    }
}
