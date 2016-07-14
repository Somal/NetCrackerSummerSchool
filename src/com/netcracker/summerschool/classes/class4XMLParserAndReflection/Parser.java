package com.netcracker.summerschool.classes.class4XMLParserAndReflection;

/**
 * Created by somal on 07.07.16.
 * The parser gives information from XML about Graphic structure.
 * After that we create tree structure based on called classes by Reflection API
 * and draw by the tree
 */

import xmlsaxparser.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Parser {

    private BaseElement root;
    private Document document;

    public Parser(Document document) {
        this.document = document;
    }

    public BaseElement getRoot() {
        return this.root;
    }

    public void parse() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        this.recursion(document, null, 0);
    }

    public void recursion(Node node, BaseElement parent, int depth) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        BaseElement be;
        try {
            if (node.getChildNodes().getLength() == 0)
//                System.out.println(node.getNodeValue());
                if (parent != null && !(parent instanceof Panel))
                    parent.setLabel(node.getNodeValue());
            Class c = Class.forName(node.getNodeName());
            be = (BaseElement) c.newInstance();

            if (parent == null && this.root == null)
                this.root = be;
            if (parent != null) {
                parent.add(be);
            }

            for (int i = 0; i < node.getAttributes().getLength(); i++) {
                Node attr = node.getAttributes().item(i);
                String varName = attr.getNodeName();
                String value = attr.getNodeValue();
//                System.out.println(varName);
//                System.out.println(value);
                Method m = c.getMethod("set" + varName, new Class[]{String.class});
                m.invoke(be, new Object[]{value});
            }


        } catch (ClassNotFoundException e) {
            be = null;
        }


        for (int i = 0; i < depth; i++)
            System.out.print("   ");
        System.out.print(node.getNodeName() + " ");
        System.out.print(be + " ");
        System.out.println(parent);
        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
            recursion(node.getChildNodes().item(i), be, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("src/com/netcracker/summerschool/class4/XMLParserAndReflection/old.xml");
        Parser p = new Parser(document);
        p.parse();
        UTIL.draw(p.getRoot(), "Drawer");
    }


}
