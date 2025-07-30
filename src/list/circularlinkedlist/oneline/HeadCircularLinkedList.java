package list.circularlinkedlist.oneline;

import list.interfaces.ListInterface;
import node.Node;

public class HeadCircularLinkedList<E> implements ListInterface<E> {

    private Node<E> head;
    private int size;

    public HeadCircularLinkedList() {
        size = 0;
    }

    @Override
    public void add(int index, E x) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> newNode = new Node<>(x);

        if (index == 0) {
            if (head == null) {
                head = newNode;
            }
            // 아래 주석의 이유 -> 양방향 단일 연결리스트는 굳이 헤드를 안옮겨도 될듯?
//            else {
//                newNode.next = head;
//                head.next = newNode;
//                head = newNode;
//            }
        } else {
            Node<E> prevNode = getNode(index - 1);
            if (prevNode.next == head) {
                prevNode.next = newNode;
                newNode.next = head;
            } else {
                newNode.next = prevNode.next;
                prevNode.next = newNode;
            }
        }
        size++;
    }

    private Node<E> getNode(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> currentNode = head;

        for (int j = 0; j < i; j++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }


    @Override
    public void append(E x) {
        Node<E> newNode = new Node<>(x);
        Node<E> prevNode = getNode(size - 1);

        newNode.next = prevNode.next;
        prevNode.next = newNode;

        size++;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        E itemToReturn;
        Node<E> nodeToRemove;

        if (index == 0) {
            // Removing the head
            nodeToRemove = head;
            itemToReturn = nodeToRemove.item;

            if (size == 1) {
                // If it's the only node, the list becomes empty
                head = null;
            } else {
                // Find the last node to update its 'next' pointer
                Node<E> lastNode = getNode(size - 1);
                head = head.next;
                lastNode.next = head; // The last node now points to the new head
            }
        } else {
            // Removing a node from the middle or end
            Node<E> prevNode = getNode(index - 1);
            nodeToRemove = prevNode.next;
            itemToReturn = nodeToRemove.item;
            prevNode.next = nodeToRemove.next; // Unlink the node
        }

        nodeToRemove.next = null; // Help GC by clearing the next pointer of the removed node
        size--;
        return itemToReturn;
    }

    @Override
    public boolean removeItem(E x) {
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
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        getNode(index).item = x;
        if (index == 0) {
            head.item = x;
        }
    }

    @Override
    public int indexOf(E x) {
        Node<E> currentNode = head;

        for (int i = 0; i <size; i++) {
            currentNode = currentNode.next;
            if(currentNode.item.equals(x)){
                return i - 1;
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
        for (int i = 0; i < size; i++) {
            sb.append(current.item);
            if (i < size - 1) {
                sb.append("->");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
