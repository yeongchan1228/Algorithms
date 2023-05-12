package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P1547 { // Minimum Cost to Cut a Stick
    public static void main(String[] args) {
        int n = 7;
        int[] cuts = {1, 3, 4, 5};
        System.out.println(minCost(n, cuts));
    }

    public static int minCost(int n, int[] cuts) {
        int len = cuts.length;

        int[][] dp = new int[len + 2][len + 2];

        List<Integer> list = new ArrayList<>();
        for (int ele: cuts) {
            list.add(ele);
        }
        list.add(n);
        list.add(0, 0);
        Collections.sort(list);


        for (int i = len; i >= 1; i--) {
            for (int j = 1; j <= len; j++) {
                if (i > j) continue;

                int mini = Integer.MAX_VALUE;

                for (int ind = i; ind <= j; ind++) {
                    int cost = list.get(j + 1) - list.get(i - 1) + dp[i][ind - 1] + dp[ind + 1][j];
                    mini = Math.min(mini, cost);
                }

                dp[i][j] = mini;
            }
        }

        return dp[1][len];
    }
}
