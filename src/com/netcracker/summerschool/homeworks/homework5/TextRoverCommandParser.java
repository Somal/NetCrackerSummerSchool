package com.netcracker.summerschool.homeworks.homework5;


import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by somal on 14.07.16.
 */
public class TextRoverCommandParser {
    private Rover rover;
    private BufferedReader in;

    public TextRoverCommandParser(Rover rover, String file) throws FileNotFoundException {
        this.rover = rover;
        this.in = new BufferedReader(new FileReader(file));
    }

    public RoverCommand readNextCommand() throws IOException, ValueException {
        String commandLine = in.readLine();

        if (commandLine == null) return null;
        if (!checkWithRegExp(commandLine))
            throw new ValueException("Method is a string like moveTo(args) or turnTo(args)");
        String[] splitted = commandLine.split("\\(");
        String command = splitted[0];
        String[] args = splitted[1].split("\\)")[0].split(",");

        RoverCommand roverCommand = null;
        switch (command) {
            case "moveTo":
                if (args.length != 2) throw new ArrayStoreException("Move command must have 2 arguments");
                int x = Integer.parseInt(args[0]), y = Integer.parseInt(args[1]);
                roverCommand = new MoveCommand(this.rover, x, y);
                break;
            case "turnTo":
                if (args.length != 1) throw new ArrayStoreException("Turn command must have 1 argument");
                Direction direction = Direction.valueOf(args[0]);
                roverCommand = new TurnCommand(this.rover, direction);
                break;
            case "import":
                if (args.length != 1) throw new ArrayStoreException("Import command must have 1 argument");
                roverCommand = new ImportCommand(this.rover, args[0]);
                break;
            default:
                throw new ValueException("Method is a string like moveTo(args) or turnTo(args)");
        }

        return roverCommand;
    }

    private static boolean checkWithRegExp(String userNameString) {
        Pattern p = Pattern.compile("^[a-zA-z]+\\((.+,?)+\\)$");
        Matcher m = p.matcher(userNameString);
        return m.matches();
    }
}
