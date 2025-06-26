package week1;

public class PowerFunction {
    public static long power(int x, int n){
        if(n == 0){
            return 1;
        }
        return power(x, n-1) * x;
    }

    public static void main(String[] args) {
        System.out.println(power(2, 5));
    }
}
