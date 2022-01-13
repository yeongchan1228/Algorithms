package DP;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem2501 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        ArrayList<Integer> measure = new ArrayList<Integer>();
        for(int i = 1; i <= N; i++){
            if(N % i == 0){
                measure.add(i);
            }
        }
        if(measure.size() < K){
            System.out.print("0");
        }
        else {
            System.out.print(measure.get(K - 1));
        }
    }
}
