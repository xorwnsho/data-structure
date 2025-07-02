package arraypractice;

import java.util.ArrayList;

public class Array {
    public static void main(String[] args) {
        int[] scores = new int[5];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = i + 1;
            System.out.print(scores[i] + " ");
        }

        System.out.println();
        scores[0] = 100;

        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] +" ");
        }

        System.out.println();

        ArrayList<Integer> scores2 = new ArrayList<>();
        scores2.add(0, 0);
        scores2.add(1, 10);
        scores2.add(2, 20);
        scores2.add(3, 30);

        scores2.add(1,100);

        for (int i = 0; i < scores2.size(); i++) {
            System.out.println(scores2.get(i));
        }
    }
}
