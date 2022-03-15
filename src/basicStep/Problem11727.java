package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem11727 { // 2xn 타일링 2
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        /**
         * 1 -> 1
         * 2 -> 3
         * 3 -> 5
         */
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        if(n > 1)
            dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + (2 * dp[i - 2])) % 10007;
        }

        System.out.println(dp[n]);
    }
}
