package list.doublylinkedlist;

public class DoublyLinkedListMain {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.add(0, 20);
        list.add(1, 30);
        list.add(0, 10);
        list.add(3, 40);
        System.out.println(list);

        list.append(50);
        System.out.println(list);

        list.remove(4);
        System.out.println(list);

        list.removeItem(30);
        System.out.println(list);

        list.set(2, 30);
        System.out.println(list);

        System.out.println(list.indexOf(20));

        System.out.println(list.isEmpty());
        list.clear();
        System.out.println(list);
        System.out.println(list.isEmpty());

    }
}
