package list.circularlinkedlist.twoline;

import list.interfaces.ListInterface;
import node.DNode;

public class DoublyCircularLinkedList<E> implements ListInterface<E> {

    private DNode<E> head; // 리스트의 헤드 노드 (첫 번째 노드를 가리킴)
    private int size;      // 리스트에 있는 요소의 수

    public DoublyCircularLinkedList() {
        head = null;
        size = 0;
    }

    private DNode<E> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        DNode<E> currentNode;

        // 인덱스가 리스트를 기준으로 반으로 나눠서 사용하는 이유는
        // 양방향 연결 리스트의 장점을 살리기 위함.

        if (index < size / 2) {
            currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = head.prev;
            for (int i = 0; i < size - 1 - index; i++) {
                currentNode = currentNode.prev;
            }
        }
        return currentNode;
    }

    @Override
    public void add(int index, E x) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        DNode<E> newNode = new DNode<>(x);

        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {

            DNode<E> nextNode = (index == size) ? head : getNode(index);
            DNode<E> prevNode = nextNode.prev;

            prevNode.next = newNode;
            newNode.prev = prevNode;
            newNode.next = nextNode;
            nextNode.prev = newNode;


            if (index == 0) {
                head = newNode;
            }
        }
        size++;
    }

    @Override
    public void append(E x) {
        add(size, x);
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        DNode<E> removeNode = getNode(index);
        E item = removeNode.item;

        if (size == 1) {
            head = null;
        } else {
            DNode<E> prevNode = removeNode.prev;
            DNode<E> nextNode = removeNode.next;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;

            if (removeNode == head) {
                head = nextNode;
            }
        }

        size--;
        return item;
    }

    @Override
    public boolean removeItem(E x) {
        if (isEmpty()) {
            return false;
        }
        int index = indexOf(x);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public E get(int index) {
        return getNode(index).item;
    }

    @Override
    public void set(int index, E x) {
        DNode<E> node = getNode(index);
        node.item = x;
    }

    @Override
    public int indexOf(E x) {
        if (isEmpty()) {
            return -1;
        }
        DNode<E> currentNode = head;
        for (int i = 0; i < size - 1; i++) {
            if(currentNode.item.equals(x)){
                return i;
            }
            currentNode = currentNode.next;
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
        for (int i = 0; i < size; i++) {
            sb.append(current.item);
            if (i < size - 1) {
                sb.append(" <-> ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
