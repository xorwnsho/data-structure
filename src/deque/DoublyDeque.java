package deque;

import node.DNode;

public class DoublyDeque<E> implements DequeADT<E> {

    private DNode<E> front;
    private DNode<E> rear;
    private int size;

    public DoublyDeque() {
        front = rear = null;
        size = 0;
    }

    @Override
    public void addFront(E e) {
        DNode<E> newNode = new DNode<>(e, null, null);
        if (front == null) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
        size++;
    }

    @Override
    public void addRear(E e) {
        DNode<E> newNode = new DNode<>(e, null, null);
        if (rear == null) {
            front = rear = newNode;
        } else {
            newNode.prev = rear;
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    @Override
    public E deleteFront() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Empty deque");
        }

        E value = front.item;

        if (size == 1) {
            clear();
        } else {
            front = front.next;
            front.prev.next = null;
            front.prev = null;
        }
        size--;
        return value;

    }

    @Override
    public E deleteRear() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Empty deque");
        }

        E value = front.item;

        if (size == 1) {
            clear();
        } else {
            rear = rear.prev;
            rear.next.prev = null;
            rear.next = null;
        }
        size--;
        return value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        front = rear = null;
    }


    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        DNode<E> current = front;
        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
