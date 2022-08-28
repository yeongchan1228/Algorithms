package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1904 { // 01타일

    private final static int MOD = 15746;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[] dp = new int[n + 1];

        dp[1] = 1;
        if(n > 1) dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] % MOD + dp[i - 2] % MOD;
        }

        System.out.println(dp[n] % MOD);
    }
}
