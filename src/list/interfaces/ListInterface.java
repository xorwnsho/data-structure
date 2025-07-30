package list.interfaces;

import node.Node;

public interface ListInterface<E> {
    void add(int index, E x);
    void append(E x);
    E remove(int index);
    boolean removeItem(E x);
    E get(int index);
    void set(int index, E x);
    int indexOf(E x);
    int size();
    boolean isEmpty();
    void clear();
}
