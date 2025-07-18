package list.week1;

public class FactorialMain {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    static int factorial(int number) {
        if(number == 1) return 1;
        int result = number * factorial(number -1);
        return result;
    }
}


