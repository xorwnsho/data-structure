package queue;

public class CircularQueue<E> implements QueueADT<E>{

    private E[] circularQueue;
    private int front;
    private int tail;
    private int capacity;
    private int size;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        circularQueue = (E[]) new Object[capacity];
        front = 0;
        tail = 0;
    }

    @Override
    public void enqueue(E t) {
        if(isFull()) {
            throw new IndexOutOfBoundsException("Queue is full");
        }

        circularQueue[tail] = t;
        tail = (tail + 1) % capacity;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        E temp = circularQueue[front];
        circularQueue[front] = null;
        front = (front + 1) % capacity;
        size--;
        return temp;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return circularQueue[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            sb.append(circularQueue[index]);
            if (i < size - 1) {
                sb.append("-> ");
            }
        }

        sb.append("]");
        return sb.toString();
    }

    public int getTail(){
        return tail - 1;
    }

    public int getFront(){
        return front;
    }
}