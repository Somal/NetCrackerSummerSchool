package com.netcracker.summerschool.class2VectorInterface;

/**
 * Created by somal on 05.07.16.
 */

public class Main {
    public static void main(String[] args) throws IndexOutOfBoundsException {
        Vector<Integer> vector = new SelfResizableVector<Integer>(5);
//        System.out.println(vector);
        vector.setValue(6, 5);
//        System.out.println(vector);
        vector.setValue(0, 0);

        vector.setValue(50, 0);
//        System.out.println(vector);
//        //////

        Vector<Integer> vector1 = new ResizableVector<Integer>(5);
        System.out.println(vector1);
        vector1.setValue(2, 5);
        System.out.println(vector1);
        vector1.setValue(10, 5);
        vector1.setValue(0, 124);
        System.out.println(vector1);


//        vector.setValue(20,5);
//        System.out.println(vector.getValue(0));
    }
}

