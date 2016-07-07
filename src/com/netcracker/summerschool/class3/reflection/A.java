package com.netcracker.summerschool.class3.reflection;

import java.util.ArrayList;

/**
 * Created by somal on 06.07.16.
 */
public class A extends ArrayList<Integer>{
    public void method(){
        add(1);
        System.out.println(this);
    }
}
