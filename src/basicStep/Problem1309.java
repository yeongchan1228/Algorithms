package basicStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1309 { // 동물원
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        long[][] dp = new long[N][3];

        dp[0][0] = dp[0][1] = dp[0][2] = 1;
        for (int i = 1; i < N; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
            dp[i][1] = (dp[i - 1][0] + dp[i- 1][2]) % 9901;
            dp[i][2] = (dp[i - 1][0] + dp[i- 1][1]) % 9901;
        }

        System.out.println((dp[N - 1][0] + dp[N - 1][1] + dp[N - 1][2]) % 9901);
    }
}
