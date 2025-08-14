package queue;

public class CircularQueueMain {
    public static void main(String[] args) {
        CircularQueue<Integer> queue = new CircularQueue<>(4);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println(queue);
        System.out.println();

        queue.dequeue();
        System.out.println(queue);
        System.out.println();

        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println(queue);
        System.out.println();

        queue.dequeue();
        queue.dequeue();
        queue.enqueue(60);
        System.out.println(queue);
        System.out.println();

        System.out.println(queue.size());
        System.out.println(queue);
        System.out.println(queue.getFront());
        System.out.println(queue.getTail());
    }
}
