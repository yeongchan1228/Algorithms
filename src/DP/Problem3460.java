package DP;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem3460 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        ArrayList<Integer> N = new ArrayList<Integer>();
        for(int k = 0; k < T; k++){
            int test = in.nextInt();
            N.add(test);
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i = 0; i < T; i++) {
            while (N.get(i) != 1) {
                if (N.get(i) % 2 != 0) {
                    ans.add(1);
                } else {
                    ans.add(0);
                }
                N.set(i, N.get(i)/2);
            }
            if(N.get(i) == 1){
                ans.add(1);
            }
            for(int j = 0; j < ans.size(); j++){
                if(ans.get(j) == 1) {
                    if(j == ans.size()-1){
                        System.out.print(j);
                    }
                    else {
                        System.out.print(j+" ");
                    }
                }
            }
            ans.clear();
            if(i != T-1) {
                System.out.println();
            }
        }
    }
}
