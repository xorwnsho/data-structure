package deque;

public class DoublyDequeMain {
    public static void main(String[] args) {
        DoublyDeque<Integer> deque = new DoublyDeque<>();

        deque.addFront(20);
        deque.addRear(30);
        System.out.println(deque);

        deque.addFront(10);
        System.out.println(deque);
        deque.addRear(40);
        System.out.println(deque);
        System.out.println();

        deque.deleteFront();
        System.out.println(deque);
        deque.deleteRear();
        System.out.println(deque);
        deque.deleteFront();
        System.out.println(deque);
        System.out.println(deque.size());
        System.out.println();

        deque.deleteFront();
        System.out.println(deque);
        System.out.println(deque.isEmpty());
    }
}
