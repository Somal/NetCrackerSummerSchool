package com.netcracker.summerschool.homeworks.homework5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by somal on 14.07.16.
 */
public class XmlRoverCommandParser {
    private Rover rover;
    private List<RoverCommand> roverCommandList;
    private int count = 0;

    public XmlRoverCommandParser(Rover rover, String file) {
        this.rover = rover;
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
            SAXPars saxp = new SAXPars(rover);
            parser.parse(new File(file), saxp);
            this.roverCommandList = saxp.commands;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public RoverCommand readNextCommand() {
        return this.roverCommandList.size() > this.count ? this.roverCommandList.get(count++) : null;
    }


    public class SAXPars extends DefaultHandler {
        public List<RoverCommand> commands = new ArrayList<>();
        private Rover rover;

        public SAXPars(Rover rover) {
            super();
            this.rover = rover;
        }


        @Override
        public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
            if (qName.equals("command")) {
                RoverCommand roverCommand = null;
                switch (atts.getValue("type")) {
                    case "moveTo":
                        int x = Integer.parseInt(atts.getValue("x"));
                        int y = Integer.parseInt(atts.getValue("y"));
                        roverCommand = new MoveCommand(this.rover, x, y);
                        break;
                    case "turnTo":
                        roverCommand = new TurnCommand(this.rover, Direction.valueOf(atts.getValue("direction")));
                        break;
                    case "import":
                        try {
                            roverCommand = new ImportCommand(this.rover, atts.getValue("file"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        throw new ValueException("Method is a string like moveTo(args) or turnTo(args)");
                }
                this.commands.add(roverCommand);
            }
        }
    }

}
