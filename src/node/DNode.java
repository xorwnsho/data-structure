package node;

public class DNode<E> {
    public E item;
    public DNode<E> next;
    public DNode<E> prev;

    public DNode(E newItem) {
        item = newItem;
        next = prev = null;
    }

    public DNode(E newItem, DNode<E> nextNode, DNode<E> prevNode) {
        item = newItem;
        next = nextNode;
        prev = prevNode;
    }
}
