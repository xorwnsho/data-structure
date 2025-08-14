package queue;


import java.util.Arrays;

public class Queue<E> implements QueueADT<E> {

    private E objects[];
    private int size;
    private int front;

    public Queue(int length) {
        objects = (E[]) new Object[length];
        size = 0;
        front = 0;
    }

    @Override
    public void enqueue(E t) {

        // length를 벗어나면 예외
        if (isFull()) {
            throw new IndexOutOfBoundsException("Queue is full");
        }

        objects[size] = t;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
//        if (size() == objects.length - 1) {
//            throw new IndexOutOfBoundsException("못넣음");
//        }
        E temp = objects[front];
        objects[front] = null;
        size--;
        front++;
        return temp;
    }

    @Override
    public E peek() {
        if (size == 0)
            throw new IndexOutOfBoundsException("Queue is empty");
        return objects[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == objects.length;
    }

    @Override
    public int  size() {
        return size;
    }

    public void clear() {
        front = 0;
        size = 0;
        for (int i = 0; i < size; i++) {
            objects[i] = null;
        }
    }


    @Override
    public String toString() {
        if (isEmpty()) {
            return "empty queue";
        }
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % objects.length;
            sb.append(objects[index]);
            if (i < size - 1) {
                sb.append(" -> ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
