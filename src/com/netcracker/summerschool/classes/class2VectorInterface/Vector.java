package com.netcracker.summerschool.classes.class2VectorInterface;

/**
 * Created by somal on 05.07.16.
 * <p>
 * Vector is a simple interface of store data structure. The interface Vector have 2 implementation: SelfResizableVector
 * and ResizalbeVector. First is self-resizing by access on unavailable index (index>=length).
 * <p>
 * In second case, class ResizableVector have method resize, which must be run before access on unavailable index.
 * <p>
 * First class based on array, second - on linked list.
 */
public interface Vector<T>  {

    public void setValue(int index, T O);

    public T getValue(int index);

    public int getLength();

}
