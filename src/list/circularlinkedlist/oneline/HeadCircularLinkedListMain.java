package list.circularlinkedlist.oneline;

public class HeadCircularLinkedListMain {
    public static void main(String[] args) {
        HeadCircularLinkedList<Integer> list = new HeadCircularLinkedList<>();

        list.add(0, 10);
        System.out.println(list);

        list.add(1, 20);
        System.out.println(list);

        list.add(2,40);
        System.out.println(list);

        list.add(2,30);
        System.out.println(list);

        list.append(50);
        System.out.println(list);

        System.out.println(list.remove(0));
        System.out.println(list);

        System.out.println(list.remove(2));
        System.out.println(list);

        System.out.println(list.removeItem(20));
        System.out.println(list);

        list.set(0,10);
        System.out.println(list);

        list.set(1,20);
        System.out.println(list);

        System.out.println(list.size());

        System.out.println(list.indexOf(10));

        list.clear();
        System.out.println(list);
        System.out.println(list.isEmpty());
    }
}
