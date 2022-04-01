package basicStep;

import java.io.*;

public class Problem10844 { // 쉬운 계단 수
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());

        long[][] dp = new long[N+1][10]; // 앞자리
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][1] % 1000000000;
            for (int j = 1; j < 10; j++) {
                if(j == 9) {
                    dp[i][j] += dp[i - 1][j - 1];
                    dp[i][j] %= 1000000000;
                }else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                    dp[i][j] %= 1000000000;
                }
            }
        }

        long result = 0;
        for (int i = 1; i < 10; i++) {
            result += dp[N][i];
        }

        out.write(String.valueOf(result % 1000000000));
        out.flush();
        out.close();
    }
}
