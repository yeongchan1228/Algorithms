package basicStep;

import java.io.*;

/**
 * Created by YC on 2022/10/11.
 */
public class Problem9658 { // 돌 게임 4
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        int[] dp = new int[n + 1];
        dp[1] = 1;
        if (n > 1) {
            dp[2] = 0;
        }
        if (n > 2) {
            dp[3] = 1;
        }

        for (int i = 4; i <= n; i++) {
            if (dp[i - 1] + dp[i - 3] + dp[i - 4] > 0) {
                dp[i] = 0;
            } else {
                dp[i] = 1;
            }
        }

        out.write(dp[n] == 0 ? "SK" : "CY");
        out.flush();
        out.close();
    }
}
