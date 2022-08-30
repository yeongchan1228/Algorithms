package basicStep;

import java.io.*;

public class Problem9625 { // BABBA
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());

        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = 1;
        if (n > 1) {
            dp[1][0] = 1;
            dp[1][1] = 1;
        }
        for (int i = 2; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        System.out.println(dp[n - 1][0] + " " + dp[n - 1][1]);
    }
}
