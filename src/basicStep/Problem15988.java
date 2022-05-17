package basicStep;

import java.io.*;

public class Problem15988 { // 1, 2, 3 더하기 3
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N];
        long[] dp;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int var = Integer.parseInt(in.readLine());
            max = Math.max(max, var);
            arr[i] = var;
        }

        dp = new long[max + 1];

        dp[1] = 1;
        if(max > 1) dp[2] = 2;
        if(max > 2) dp[3] = 4;

        for (int j = 4; j <= max; j++) {
            dp[j] = (dp[j - 1] + dp[j - 2] + dp[j - 3]) % 1000000009;
        }

        for (int i = 0; i < arr.length; i++) {
            out.write(String.valueOf(dp[arr[i]]) + "\n");
        }

        out.flush();
        out.close();
    }
}
