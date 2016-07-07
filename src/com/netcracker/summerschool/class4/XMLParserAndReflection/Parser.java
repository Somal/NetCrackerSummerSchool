package com.netcracker.summerschool.class4.XMLParserAndReflection;

/**
 * Created by somal on 07.07.16.
 */

import xmlsaxparser.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.IOException;

public class Parser {

    public BaseElement root;


    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, ClassNotFoundException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("src/com/netcracker/summerschool/class4/XMLParserAndReflection/old.xml");

        Class c = Class.forName(document.getNodeName());
//        recursion(document, c);

    }

    public static void recursion(Node node, BaseElement parent) {
        System.out.println(node.getNodeName());
        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
//            recursion(node.getChildNodes().item(i));
        }

    }

}
