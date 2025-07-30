package list.circularlinkedlist.twoline;

public class DoublyCircularLinkedListMain {
    public static void main(String[] args) {
        DoublyCircularLinkedList<Integer> list = new DoublyCircularLinkedList<>();

        list.add(0, 10);
        list.add(1,40);
        list.add(1,30);
        list.add(1,20);
        System.out.println(list);

        list.append(50);
        System.out.println(list);

        list.remove(0);
        System.out.println(list);


        list.removeItem(40);
        System.out.println(list);

        list.set(0, 10);
        System.out.println(list);

        list.clear();
        System.out.println(list);
        System.out.println(list.isEmpty());
    }
}
