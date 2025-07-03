package arraypractice;

import java.util.Arrays;

public class ArrayList<E> implements interfaces.ListInterface<E> {

    Object[] list = new Object[10];
    int listSize = 0;

    @Override
    public void add(int i, E x) {
        if(list[i] != null) {
            rightShift(i);
        }
        if (i >= 0 && i <= list.length) {
            list[i] = x;
            listSize = i + 1;
        }
    }

    @Override
    public void append(E x) {
        if (listSize < list.length) {
            list[listSize] = x;
            listSize++;
        }
    }

    private void rightShift(int i) {
        for (int j = listSize - 1; j >= i; j--) {
            list[j + 1] = list[j];
        }
        listSize++;
    }

    private void leftShift(int i) {
        for (int index = i + 1; index < listSize; index++) {
            list[index-1] = list[index];
        }
    }

    @Override
    public E remove(int i) {
        list[i] = null;
        leftShift(i);
        listSize--;
        return null;
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
        if(i >= 0 && i <= listSize) {
            list[i] = x;
        }
    }

    @Override
    public int indexOf(E x) {
        for (int index = 0; index < listSize; index++) {
            if(list[index] == null){
                continue;
            }
            if(list[index].equals(x)) return index;
        }
        return -1;
    }

    @Override
    public int size() {
        return listSize;
    }

    @Override
    public boolean isEmpty() {
        if(listSize == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        for (int index = 0; index < listSize; index++) {
            list[index] = null;
            listSize =0 ;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(list, listSize));
    }
}

