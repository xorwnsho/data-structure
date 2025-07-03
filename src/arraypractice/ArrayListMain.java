package arraypractice;

public class ArrayListMain {
    public static void main(String[] args) {
        ArrayList<Integer> listMain = new ArrayList<>();

        listMain.add(0, 10);
        listMain.add(1, 30);
        listMain.add(1, 40);
        listMain.add(5, 20);
        listMain.append(100);
        listMain.remove(2);
        // 10 40 null null 20 100
        listMain.set(1, 50);
        // 10 50 null null 20 100

        System.out.println(listMain);
        System.out.println(listMain.get(1));

        System.out.println(listMain.indexOf(100));  // 5
        System.out.println(listMain.size());  // 6

        listMain.clear();
        System.out.println(listMain.isEmpty());
    }
}
