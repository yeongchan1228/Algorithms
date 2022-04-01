package basicStep;

import java.io.*;

public class Problem11057 { // 오르막 수
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        int[][] dp = new int[N + 1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] = dp[i][j] % 10007;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[N][i];
        }

        out.write(String.valueOf(result));
        out.flush();
        out.close();

    }
}
