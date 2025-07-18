package list.week1;

public class Main {
    static void myFunc(int number) {
        if (number > 10) return;
        System.out.println(number);
        myFunc(number + 1);
    }

    public static void main(String[] args) {
        myFunc(1);
    }
}
