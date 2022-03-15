package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1003 { // 피보나치 함수
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int[] init = new int[N];

        int max = 0;
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(in.readLine());

            if(max < value)
                max = value;

            init[i] = value;
        }

        int dp[][] = new int[max + 1][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        if(max > 0) {
            dp[1][1] = 1;
            dp[1][0] = 0;
        }

        /**
         * dp[3] = dp[2] + dp[1] -> dp[1] + dp[0] + dp[1] 2 1
         * dp[4] = dp[3] + dp[2] -> dp[2] +dp[1] + dp[1] + dp[0] -> dp[1] + dp[0] + dp[1] + dp[1] + dp[0] 3 2
         * dp[5] = dp[4] + dp[3] -> 5 3
         */
        for (int i = 2; i <= max; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        for (int i = 0; i < N; i++) {
            int num = init[i];
            System.out.println(dp[num][0] + " " + dp[num][1]);
        }

    }
}
