package basicStep;

import java.io.*;

public class Problem2156 { // 포도주 시식
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }

        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = arr[1];
        if(N > 1)
            dp[2] = dp[1] + arr[2];

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]));
        }

        out.write(String.valueOf(dp[N]));
        out.flush();
        out.close();
    }
}
