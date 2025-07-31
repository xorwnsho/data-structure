package stack;

public class LinkedStackMain {
    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<>();

        stack.push(1);
        System.out.println(stack);

        stack.push(2);
        System.out.println(stack);

        System.out.println(stack.size());

        stack.pop();
        System.out.println(stack);


        stack.push(2);
        System.out.println(stack);
        System.out.println(stack.peek());

        stack.clear();
        System.out.println(stack);
        System.out.println(stack.isEmpty());
    }
}
