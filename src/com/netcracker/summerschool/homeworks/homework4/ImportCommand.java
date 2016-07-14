package com.netcracker.summerschool.homeworks.homework4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by somal on 14.07.16.
 */
public class ImportCommand implements RoverCommand {
    private List<RoverCommand> roverCommandList = new ArrayList<>();

    public ImportCommand(Rover rover, String[] args) throws IOException {
        if (args.length != 1) throw new ArrayStoreException("Args length must be equals 1");
        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        RoverCommandParser programParser = new RoverCommandParser(rover, in);


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
