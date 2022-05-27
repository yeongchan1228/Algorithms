package basicStep;

import java.io.*;

public class Problem15990 { // 1, 2, 3 더하기 5
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int var = Integer.parseInt(in.readLine());
            arr[i] = var;
            max = Math.max(max, var);
        }

        long[][] dp = new long[max + 1][4];
        dp[1][1] = 1;
        if(max > 2){
            dp[2][2] = 1;
        }
        if(max > 3){
            dp[3][1] = 1;
            dp[3][2] = 1;
            dp[3][3] = 1;
        }

        for (int i = 4; i <= max; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % 1000000009;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % 1000000009;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % 1000000009;
        }

        for (int i = 0; i < arr.length; i++) {
            out.write((dp[arr[i]][1] + dp[arr[i]][2] + dp[arr[i]][3]) % 1000000009 + "\n");
        }
        out.flush();
        out.close();
    }
}
