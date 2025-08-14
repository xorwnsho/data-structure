package deque;

public class ArrayDequeMain {
    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>(4);

        deque.addFront(40);
        deque.addFront(30);
        deque.addFront(20);
        deque.addFront(10);
        System.out.println(deque);

//        deque.addFront(10);
//        System.out.println(deque);
//        deque.addRear(40);
//        System.out.println(deque);
//        System.out.println();
//
//        deque.deleteFront();
//        System.out.println(deque);
//        deque.deleteRear();
//        System.out.println(deque);
//        deque.deleteFront();
//        System.out.println(deque);
//        System.out.println(deque.size());
//        System.out.println();
//
//        deque.deleteFront();
//        System.out.println(deque);
//        System.out.println(deque.isEmpty());
    }
}
