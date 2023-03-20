package middleStep;

import java.io.*;

public class Problem14945 { // 불장난
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        int[][] dp = new int[n + 1][n + 1];
        if (n >= 2) {
            dp[2][1] = 2;
        }

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i][j] = (dp[i - 1][j] * 2 + dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 10007;
            }
        }

        int answer = 0;
        for (int i = 1; i <= n - 1; i++) {
            answer += dp[n][i];
        }

        out.write(String.valueOf(answer % 10007));
        out.flush();
        in.close();
        out.close();
    }
}
