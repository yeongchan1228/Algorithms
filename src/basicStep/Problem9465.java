package basicStep;

import java.io.*;

public class Problem9465 { // 스티커
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(in.readLine());

        int[][] arr;
        int[][] dp;
        int result = 0;
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(in.readLine());
            arr = new int[2][number + 1];
            dp = new int[2][number + 1];
            for (int j = 0; j < 2; j++) {
                String[] str = in.readLine().split(" ");
                for (int k = 1; k <= str.length; k++) {
                    arr[j][k] = Integer.parseInt(str[k - 1]);
                }
            }

            dp[0][0] = 0;
            dp[1][0] = 0;
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];
            for (int j = 2; j <= number; j++) {
                dp[0][j] = Math.max(dp[0][j - 1], dp[1][j - 1] + arr[0][j]);
                dp[1][j] = Math.max(dp[1][j - 1], dp[0][j - 1] + arr[1][j]);
            }
            result = Math.max(dp[0][number], dp[1][number]);
            sb.append(result).append('\n');
        }

        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
