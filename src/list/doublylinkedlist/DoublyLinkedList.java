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
    public void add(int i, E x) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
        }

        DNode<E> newNode = new DNode<>(x, null, null);

        if (i == 0) {
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
            for (int j = 0; j < i - 1; j++) {
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
    public E remove(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }

        DNode<E> currentNode = head;

        if (i == 0) {
            E value = head.item;
            head = head.next;
            head.prev = null;
            size--;
            return value;
        } else {
            for (int j = 0; j < i; j++) {
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
//        DNode<E> currentNode = head;
//
//        for (int i = 0; i < size(); i++) {
//            currentNode = currentNode.next;
//            if (Objects.equals(currentNode.item, x)) {
//                if (currentNode == head) {
//                    head = currentNode.next;
//                    head.prev = null;
//                    size--;
//                    return true;
//                }
//                if (currentNode == tail) {
//                    tail = currentNode.prev;
//                    tail.next = null;
//                    size--;
//                    return true;
//                } else {
//                    currentNode.prev.next = currentNode.next;
//                    currentNode.next.prev = currentNode.prev;
//                    size--;
//                    return true;
//                }
//            }
//        }
        return false;
    }

    @Override
    public E get(int i) {
        DNode<E> currentNode = head;
        for (int j = 0; j < size; j++) {
            if (j == i) {
                return currentNode.item;
            }
        }
        return null;
    }

    @Override
    public void set(int i, E x) {

    }

    @Override
    public int indexOf(E x) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

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
