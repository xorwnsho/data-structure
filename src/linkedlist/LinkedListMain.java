package linkedlist;

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList<Integer> integerList = new LinkedList<>();
        integerList.add(0, 300);
        integerList.add(0, 100);
        integerList.append(500);
        integerList.remove(2);
        integerList.append(700);
        integerList.remove(1);

        for (int i = 0; i < integerList.size(); i++) {
            System.out.println(integerList.get(i));
        }
    }
}
