package linkedlist;

public class LinkedList<E> implements ListInterface<E> {
    private Node<E> head;
    private int numItems;

    public LinkedList() {
        numItems = 0;
        head = new Node<>(null,null);  // -> 더미 헤드 노드 생성
    }

    @Override
    public void add(int i, E x) {
        if(i >= 0 && i <= numItems) {
            Node<E> prevNode = getNode(i-1);
            Node<E> newNode = new Node<>(x, prevNode.next);
            prevNode.next = newNode;
            numItems++;
        } else {
            // 에러처리
        }
    }

    @Override
    public void append(E x) {
        Node<E> prevNode =head;
        while(prevNode.next != null) {
            prevNode = prevNode.next;
        }
        Node<E> newNode = new Node<>(x, null);
        prevNode.next = newNode;
        numItems++;
    }

    @Override
    public E remove(int i) {
        if(i >= 0 && i <= numItems - 1) {
            Node<E> prevNode = getNode(i-1);
            Node<E> currNode = prevNode.next;
            prevNode.next = currNode.next;
            numItems--;
            return currNode.item;
        } else return null;
    }

    @Override
    public boolean removeItem(E x) {
        Node<E> currNode = head;
        for (int i = 0; i < numItems; i++) {
            Node<E> prevNode = currNode;
            currNode = prevNode.next;
            if(((Comparable<E>) (currNode.item)).compareTo(x) == 0) {
                prevNode.next = currNode.next;
                numItems--;
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int i) {
        if (i >= 0 && i < numItems) {
            Node<E> currentNode = getNode(i);
            return currentNode.item;
        } else {
            return null; // 또는 throw new IndexOutOfBoundsException();
        }
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
        return numItems;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }
    // i번째 노드를 반환하는 헬퍼 메서드
    public Node<E> getNode(int index) {
        if (index >= -1 && index < numItems) {
            Node<E> currentNode = head;
            for (int i = 0; i <= index; i++) {
                currentNode = currentNode.next;
            }
            return currentNode;
        } else {
            return null; // 또는 예외 처리
        }
    }

}
