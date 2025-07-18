package list.DoubleLinkedList;

public class Node<E> {
    public E item;
    public Node<E> next;
    public Node<E> prev;

    public Node(E newItem) {
        item = newItem;
        next = prev = null;
    }

    public Node(E newItem, Node<E> nextNode, Node<E> prevNode) {
        item = newItem;
        next = nextNode;
        prev = prevNode;
    }
}