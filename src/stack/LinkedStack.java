package stack;

import node.Node;

import java.util.Arrays;

public class LinkedStack<E> implements StackADT<E> {

    Node<E> top = null;
    int size;

    public LinkedStack() {
        size = 0;
    }

    @Override
    public void push(E t) {

        Node<E> newNode = new Node<>(t);

        if(top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }

        size++;
    }

    @Override
    public E pop() {
        E popValue = top.item;
        top = top.next;

        size--;
        return popValue;
    }

    @Override
    public E peek() {
        Node<E> peekNode = top;
        if(peekNode == null) {
            return null;
        } else {
            return peekNode.item;
        }
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
        top = new Node<>(null);
        size = 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }


    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("]");

        Node<E> current = top;
        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }

        sb.append("[");
        sb.reverse();
        return sb.toString();
    }
}
