package basicStep;

import java.util.Scanner;

public class Problem10870 {
    static int[] arr = new int[1024];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        System.out.print(fibo(N));
    }

    public static int fibo(int n) {
        if (n <= 1)
            return n;
        else if (arr[n] != 0)
            return arr[n];
        else
            return arr[n] = fibo(n - 1) + fibo(n - 2);

    }
}
