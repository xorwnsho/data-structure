package list.linkedlist;

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList<Integer> integerList = new LinkedList<>();
        integerList.add(0, 300);
        integerList.add(1, 100);
        integerList.add(1, 200);
        integerList.append(500);
        integerList.append(100);
        integerList.remove(2);
        integerList.removeItem(100);
        System.out.println(integerList.get(0));
        integerList.set(0, 400);
        System.out.println(integerList.get(0));
        System.out.println(integerList.indexOf(400));
//        integerList.append(700);
//        integerList.remove(1);

        System.out.println(integerList);
    }
}
