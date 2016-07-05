package com.netcracker.summerschool.class2.vector;


/**
 * Created by somal on 05.07.16.
 */
public class SelfResizableVector<T> implements Vector<T> {
    Object[] array;

    public SelfResizableVector(int length) throws Exception {
        if (length < 0)
            throw new Exception("Size less than 0");
        array = new Object[length];
    }

    @Override
    public void setValue(int index, T O) throws Exception {
        if (index < 0)
            throw new Exception("Size less than 0");

        if (index < getLength()) array[index] = O;
        else {
            int oldLength = array.length;
            Object[] array1 = new Object[index + 1];
            for (int i = 0; i < oldLength; i++)
                array1[i] = array[i];
            this.array = array1;
        }

    }

    @Override
    public T getValue(int index) {
        return (T) array[index];
    }

    @Override
    public int getLength() {
        return array.length;
    }

    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < getLength(); i++) out += getValue(i) + " ";
        return out;
    }
}
