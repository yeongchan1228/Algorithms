package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1535 { // 안녕
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());

        int[] hp = new int[n+1];
        stk = new StringTokenizer(buf.readLine());
        for (int i = 1; i <= n; i++) {
            hp[i] = Integer.parseInt(stk.nextToken());
        }

        int[] happy = new int[n+1];
        stk = new StringTokenizer(buf.readLine());
        for (int i = 1; i <= n; i++) {
            happy[i] = Integer.parseInt(stk.nextToken());
        }

        int[][] dp = new int[n+1][101];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 100; j++) {
                int temp = j - hp[i];
                if (temp >= 0) {
                    dp[i][j] = Math.max(dp[i-1][temp] + happy[i], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        buf2.write(dp[n][99] + "");
        buf2.flush();
        buf.close();
        buf2.close();
    }
}