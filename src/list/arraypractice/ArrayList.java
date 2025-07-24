package list.arraypractice;

import list.interfaces.ListInterface;

import java.util.Arrays;

public class ArrayList<E> implements ListInterface<E> {

    Object[] list = new Object[10];
    int size = 0;

    @Override
    public void add(int i, E x) {
        if (list[i] != null) {
            rightShift(i);
        }
        if (i >= 0 && i <= list.length) {
            list[i] = x;
            size = i + 1;
        }
    }

    @Override
    public void append(E x) {
        if (size < list.length) {
            list[size] = x;
            size++;
        }
    }

    private void rightShift(int i) {
        for (int j = size - 1; j >= i; j--) {
            list[j + 1] = list[j];
        }
        size++;
    }

    private void leftShift(int i) {
        for (int index = i + 1; index < size; index++) {
            list[index - 1] = list[index];
        }
    }

    @Override
    public E remove(int i) {
        E temp = get(i);
        list[i] = null;
        leftShift(i);
        size--;
        return temp;
    }

    @Override
    public boolean removeItem(E x) {
        return false;
    }

    @Override
    public E get(int i) {
        return (E) list[i];
    }

    @Override
    public void set(int i, E x) {
        if (i >= 0 && i <= size) {
            list[i] = x;
        }
    }

    @Override
    public int indexOf(E x) {
        for (int index = 0; index < size; index++) {
            if (list[index].equals(x)) return index;
        }
        return -1;
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
        for (int index = 0; index < size; index++) {
            list[index] = null;
        }
        size = 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(list, size));
    }
}

