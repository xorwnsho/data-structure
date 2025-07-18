package list.DoubleLinkedList;

public class DoublyLinkedListMain {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.append(10);
        list.append(20);
        list.add(1, 15);
        list.remove(1);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
