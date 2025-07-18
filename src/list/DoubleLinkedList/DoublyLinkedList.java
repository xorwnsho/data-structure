package list.DoubleLinkedList;

public class DoublyLinkedList<E> implements list.interfaces.ListInterface<E> {
    private Node<E> head;
    private int numItems;

    public DoublyLinkedList() {
        head = new Node<>(null);     // 더미 노드
        head.next = head;            // 원형 구조
        head.prev = head;
        numItems = 0;
    }

    // 내부 메서드: index 위치의 노드 반환
    private Node<E> getNode(int index) {
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

    @Override
    public void add(int i, E x) {
        if (i >= 0 && i <= numItems) {
            Node<E> prevNode = getNode(i - 1);
            Node<E> nextNode = prevNode.next;
            Node<E> newNode = new Node<>(x, nextNode, prevNode);
            prevNode.next = newNode;
            nextNode.prev = newNode;
            numItems++;
        } else {
            throw new IndexOutOfBoundsException("인덱스 범위 초과");
        }
    }

    @Override
    public void append(E x) {
        add(numItems, x); // 맨 끝에 추가는 add(size, x)와 동일
    }

    @Override
    public E remove(int i) {
        if (i >= 0 && i < numItems) {
            Node<E> curr = getNode(i);
            Node<E> prevNode = curr.prev;
            Node<E> nextNode = curr.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            numItems--;
            return curr.item;
        } else {
            throw new IndexOutOfBoundsException("인덱스 범위 초과");
        }
    }

    @Override
    public boolean removeItem(E x) {
        return false;
    }

    @Override
    public E get(int i) {
        if (i >= 0 && i < numItems) {
            return getNode(i).item;
        } else {
            throw new IndexOutOfBoundsException("인덱스 범위 초과");
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
        return numItems == 0;
    }

    @Override
    public void clear() {
    }
}
