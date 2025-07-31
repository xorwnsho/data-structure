package list.linkedlist;

import list.interfaces.ListInterface;
import node.Node;

import java.util.Objects;

public class LinkedList<E> implements ListInterface<E> {
    private Node<E> head;
    private int size;

    public LinkedList() {
        size = 0;
        head = new Node<>(null, null);
    }

    // i번째 노드를 반환하는 헬퍼 메서드
    private Node<E> getNode(int index) {

        Node<E> currentNode = head;
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;

    }

    @Override
    public void add(int i, E newItem) {
        // 예외
        // 1. 0 <= index <= size 인 경우가 유효한 인덱스 값임 -> 아니면 예외처리

        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> prevNode = getNode(i - 1);
        prevNode.next = new Node<>(newItem, prevNode.next);
        size++;

    }

    @Override
    public void append(E newItem) {
        Node<E> prevNode = head;
        while (prevNode.next != null) {
            prevNode = prevNode.next;
        }
        prevNode.next = new Node<>(newItem, null);
        size++;
    }

    @Override
    public E remove(int i) {
        if (i < 0 || i >= size) throw new IndexOutOfBoundsException();
        Node<E> prevNode = getNode(i - 2);
        Node<E> currNode = prevNode.next;
        prevNode.next = currNode.next;
        size--;
        return currNode.item;
    }

    @Override
    public boolean removeItem(E x) {
        Node<E> prevNode = head;
        for (int i = 0; i < size(); i++) {
            if (Objects.equals(prevNode.next.item, x)) {
                prevNode.next = prevNode.next.next;
                size--;
                return true;
            } else {
                prevNode = prevNode.next;
            }
        }
        return false;
    }

    @Override
    public E get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> currentNode = getNode(i);
        return currentNode.item;

    }

    @Override
    public void set(int i, E x) {
        if(i < 0 || i >= size) throw new IndexOutOfBoundsException();
        getNode(i).item = x;
    }

    @Override
    public int indexOf(E x) {
        for (int i = 0; i < size(); i++) {
            if(Objects.equals(get(i),x)){
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
        head.next = null;
        size = 0;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node<E> current = head;

        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append("->");
            }
            current = current.next;
        }
        return sb.toString();
    }
}
