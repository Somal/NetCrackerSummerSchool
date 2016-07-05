package com.netcracker.summerschool.class2.vector;

import java.util.LinkedList;

/**
 * Created by somal on 05.07.16.
 */
public class ResizableVector<T> implements Vector<T> {
    LinkedList<T> list;


    public ResizableVector(int length) throws Exception {
        if (length < 0)
            throw new Exception("Size less than 0");
        list = new LinkedList<T>();
        for (int i = 0; i < length; i++) list.add(null);
    }

    @Override
    public void setValue(int index, T O) throws Exception {
        if (index < getLength()) list.set(index, O);
        else {
            resizeLength(index + 1);
//            list.set(index, O);
        }
    }

    @Override
    public T getValue(int index) {
        return list.get(index);
    }

    @Override
    public int getLength() {
        return list.size();
    }

    private void resizeLength(int size) {
        if (size > getLength()) {
            int count = size - getLength();
            for (int i = 0; i < count; i++) list.add(null);
        } else {
            int count = getLength() - size;
            for (int i = 0; i < count; i++) list.removeLast();
        }
    }

    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < getLength(); i++) out += getValue(i) + " ";
        return out;
    }
}