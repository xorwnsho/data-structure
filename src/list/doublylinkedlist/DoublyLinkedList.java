package list.doublylinkedlist;

import node.DNode;
import list.interfaces.ListInterface;

public class DoublyLinkedList<E> implements ListInterface<E> {
    private DNode<E> head;
    private DNode<E> tail;
    private int size;

    public DoublyLinkedList() {
        size = 0;
        // head = new DNode<>(null, null, null);
    }

    @Override
    public void add(int index, E x) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        DNode<E> newNode = new DNode<>(x, null, null);

        if (index == 0) {
            // Insert at the head
            if (head == null) { // Empty list
                head = newNode;
                tail = newNode;
            } else { // Non-empty list
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        } else {
            // Find the node before the insertion point
            DNode<E> prevNode = head;
            for (int i = 0; i < index - 1; i++) {
                prevNode = prevNode.next;
            }

            DNode<E> nextNode = prevNode.next;

            newNode.next = nextNode;
            newNode.prev = prevNode;
            prevNode.next = newNode;

            if (nextNode != null) {
                nextNode.prev = newNode;
            } else {
                // We are adding at the end of the list
                tail = newNode;
            }
        }
        size++;
    }

    @Override
    public void append(E x) {
        DNode<E> newNode = new DNode<>(x, null, null);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        DNode<E> currentNode = head;

        if (index == 0) {
            E value = head.item;
            head = head.next;
            head.prev = null;
            size--;
            return value;
        } else {
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;

            }
            E value = currentNode.item;
            currentNode.prev.next = currentNode.next;
            if (currentNode.next != null) {
                currentNode.next.prev = currentNode.prev;
            }
            size--;
            return value;
        }
    }

    @Override
    public boolean removeItem(E x) {
        DNode<E> currentNode = head;
        for (int i = 1; i < size ; i++) {
            currentNode = currentNode.next;
            if(currentNode.item.equals(x)){
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        DNode<E> currentNode = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                return currentNode.item;
            }
        }
        return null;
    }

    @Override
    public void set(int index, E x) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        DNode<E> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.item = x;
    }


    @Override
    public int indexOf(E x) {
        DNode<E> currentNode = head;

        for (int i = 1; i < size; i++) {
            currentNode = currentNode.next;
            if(currentNode.item.equals(x)){
                return i;
            }
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
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        DNode<E> current = head;

        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append("->");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
