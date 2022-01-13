package basicStep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem10818 { // 최대, 최소 값 문제
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        ArrayList<Integer> K = new ArrayList<Integer>();
        for(int i = 0; i < N; i++){
            int test = in.nextInt();
            K.add(test);
        }

        int max = Collections.max(K);
        int min = Collections.min(K);
        System.out.print(min + " " + max);


    }
}
