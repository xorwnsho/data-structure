package queue;

public class QueueMain {

    public static void main(String[] args) {
        Queue<Integer> list = new Queue<>(5);

        list.enqueue(10);
        list.enqueue(20);
        list.enqueue(30);
        list.enqueue(40);
        list.enqueue(50);
        System.out.println(list);
        System.out.println("Is list full? : " + list.isFull());


        list.dequeue();
        System.out.println(list);
        list.dequeue();
        System.out.println(list);
        System.out.println(list.peek());
        System.out.println(list.size());
        System.out.println("Is list empty? : " + list.isEmpty());

        list.clear();
        System.out.println("Is list empty? : " + list.isEmpty());


    }
}
