package stack;

import java.util.Arrays;

public class Stack<E> implements StackADT<E> {

    private E[] objectList;
    private int size;

    public Stack() {
        objectList = (E[]) new Object[10];
        size = 0;
    }

    @Override
    public void push(E x) {
        objectList[size]  = x;
        size++;

    }

    @Override
    public E pop() {
        E popValue = (E) objectList[size - 1];
        objectList[size - 1] = null;

        size--;

        return popValue;
    }

    @Override
    public E peek() {
        return (E) objectList[size - 1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        objectList = (E[]) new Object[10];
        size = 0;
    }

    @Override
    public boolean isFull() {
        return size == objectList.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(objectList, size));
    }
}
