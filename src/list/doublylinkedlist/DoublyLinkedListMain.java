package list.doublylinkedlist;

public class DoublyLinkedListMain {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.add(0,20);
        list.add(1,30);
        list.add(0,10);
        list.add(3,40);
        list.append(50);
        list.remove(4);
//        list.removeItem(40);

//        System.out.println(list.get(0));
        System.out.println(list);

    }
}
