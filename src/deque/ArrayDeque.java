package deque;

public class ArrayDeque<E> implements DequeADT<E> {
    private E[] deque;
    private int size;
    private int front;
    private int rear;

    public ArrayDeque(int length) {
        deque = (E[]) new Object[length];
        size = 0;
        front = 0;
        rear = 0;
    }

    @Override
    public void addFront(E e) {
        if (size == deque.length) {
            throw new IndexOutOfBoundsException("Queue is full");
        }
        front = (front - 1 + deque.length) % deque.length;
        deque[front] = e;
        size++;
    }

    @Override
    public void addRear(E e) {
        if (size == deque.length) {
            throw new IndexOutOfBoundsException("Queue is full");
        }

        rear = ((rear + 1) + deque.length) % deque.length;
        deque[rear] = e;
        size++;
    }

    @Override
    public E deleteFront() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }

        E value = deque[front];

        if (size == 1) {
            clear();
        } else {
            deque[front] = null;
            front = (front + 1) % deque.length;
            size--;
        }

        return value;
    }

    @Override
    public E deleteRear() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }

        E value = deque[front];

        if (size == 1) {
            clear();
        } else {
            deque[front] = null;
            front = (front + 1) % deque.length;
            size--;
        }

        return value;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < deque.length; i++) {
            sb.append(deque[i]);
            if (i < deque.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
