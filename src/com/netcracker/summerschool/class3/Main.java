package com.netcracker.summerschool.class3;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;

/**
 * Created by somal on 06.07.16.
 */
public class Main {
    public static void main(String[] args) throws IOException, InvocationTargetException, IllegalAccessException {
        ArrayList<String> methods = null;
        try {
            BufferedReader in = new BufferedReader(new FileReader("/media/somal/EC70EE3770EE0862/HiTech/NetCrackerSummerSchool/src/com/netcracker/summerschool/class3/in.txt")); //InputStreamReader(System.in));

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

            Class c = Class.forName(getClassName(methods.get(0)));
            Method m = c.getMethod(getMethodName(methods.get(0)));
            m.invoke(new A(), null);

            c = Class.forName(getClassName(methods.get(1)));
            m = c.getMethod(getMethodName(methods.get(1)));
            System.out.println(m.invoke(new B(), null));

            c = Class.forName(getClassName(methods.get(2)));
            m = c.getMethod(getMethodName(methods.get(2)), new Class[]{Double.class});
            System.out.println(m.invoke(new C(), new Object[]{3.0}));

        } catch (ClassNotFoundException e1) {
            System.out.println(e1);
        } catch (NoSuchMethodException e1) {
            System.out.println(e1);
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

}
