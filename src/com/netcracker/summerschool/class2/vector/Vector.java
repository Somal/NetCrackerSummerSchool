package com.netcracker.summerschool.class2.vector;

/**
 * Created by somal on 05.07.16.
 */
public interface Vector<T> {

    public void setValue(int index, T O) throws Exception;

    public T getValue(int index);

    public int getLength();

}
