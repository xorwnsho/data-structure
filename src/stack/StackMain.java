package stack;

public class StackMain {
    public static void main(String[] args) {
        Stack<Integer> list = new Stack<>();

        list.push(10);
        System.out.println(list);

        list.push(20);
        System.out.println(list);

        list.push(30);
        System.out.println(list);

        System.out.println(list.pop());
        System.out.println(list);

        System.out.println(list.peek());

        list.push(30);
        list.push(40);
        list.push(50);
        list.push(60);
        list.push(70);
        list.push(80);
        list.push(90);
        list.push(100);
        System.out.println(list);

        System.out.println(list.isFull());

        list.clear();
        System.out.println(list);
    }
}
