package com.netcracker.summerschool.homeworks.homework5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by somal on 14.07.16.
 */
public class ImportCommand implements RoverCommand {
    private List<RoverCommand> roverCommandList = new ArrayList<>();

    public ImportCommand(Rover rover, String file) throws IOException {
//        TextRoverCommandParser programParser = new TextRoverCommandParser(rover, args[0]);
        XmlRoverCommandParser programParser = new XmlRoverCommandParser(rover, file);

        RoverCommand command;
        while (true) {
            command = programParser.readNextCommand();
            if (command == null) break;
            this.roverCommandList.add(command);
        }
    }

    @Override
    public void execute() {
        this.roverCommandList.forEach(RoverCommand::execute);
    }
}
