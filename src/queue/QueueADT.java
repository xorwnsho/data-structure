package queue;

public interface QueueADT<E> {

    void enqueue(E t);

    E dequeue();

    E peek();

    boolean isEmpty();

    boolean isFull();

    int size();
}
