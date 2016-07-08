package com.netcracker.summerschool.class3.reflection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by somal on 06.07.16.
 */


public class Main {
    public static void main(String[] args) throws IOException, InvocationTargetException, IllegalAccessException, InstantiationException {
        ArrayList<String> methods = null;
        BufferedReader in = new BufferedReader(new FileReader("src/com/netcracker/summerschool/class3/reflection/in.txt")); //InputStreamReader(System.in));

        methods = new ArrayList<>();
        String tmp = "";
        int count = 0;
        while (true) {
            tmp = in.readLine();
            if (tmp == null)
                break;
            else {
                methods.add(tmp);
                count++;
            }
        }
        in.close();

        for (int i = 0; i < count; i++)
            try {
                Class c = Class.forName(getClassName(methods.get(i)));
                String methodName = getMethodName(methods.get(i));
                ArrayList<Method> methodArrayList = new ArrayList<Method>(1);
                for (Method m : c.getMethods())
                    if (m.getName().equals(methodName)) {
                        methodArrayList.add(m);

                        try {
//                           System.out.println(m.getReturnType().getName()=="void"
                            Object result = m.invoke(c.newInstance(), getArguments(methods.get(i)));
                            System.out.print(result == null ? "" : result + "\n");
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }

//                System.out.println(methodArrayList);
            } catch (ClassNotFoundException e1) {
                System.out.println(e1);
//            } catch (NoSuchMethodException e1) {
//                System.out.println(e1);
            }
    }

    public static String getClassName(String input) {
        String classes = input.split("\\(")[0];
        String[] classesArray = classes.split("\\.");
        String[] tmp = new String[classesArray.length - 1];
        for (int i = 0; i < tmp.length; i++)
            tmp[i] = classesArray[i];
        return String.join(".", tmp);
    }

    public static String getMethodName(String input) {
        String words = input.split("\\(")[0];
        String[] byDot = words.split("\\.");
        return byDot[byDot.length - 1];
    }

    public static Double[] getArguments(String input) {
        String word = input.split("\\(")[1];
        if (word.split("\\)").length == 0) return null;
        String words = word.split("\\)")[0];
        String[] args = words.split(",");
        Double[] argsDouble = new Double[args.length]; // used for primitives
        for (int i = 0; i < args.length; i++)
            argsDouble[i] = Double.parseDouble(args[i]);
        return argsDouble;
    }

}
