package list.week1;

public class TowerOfHanoiMain {
    public static void main(String[] args) {
        int numberOfDisks = 3;
        char source = 'A';
        char destination = 'C';
        char assist = 'B';

        hanoi(numberOfDisks, source, destination, assist); // 3, A, C, B
    }

    public static void hanoi(int count, char from, char to, char temp){
        if(count == 0 ){
            return;
        }
        hanoi(count - 1, from, temp, to); // 2, A, B, C
        System.out.println("원반 " + count + "를 " + from + "에서 " + to + "로 이동");
        hanoi(count -1, temp, to, from);
    }
}


// 출력