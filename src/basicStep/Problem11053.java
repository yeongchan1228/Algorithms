package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem11053 { // 가장 긴 증가하는 부분 수열
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        /**
         * 10, 20, 10, 30, 20, 50
         */
        int[] dp = new int[N+1];

        for (int i = 1; i <= N; i++) {
            dp[i] = 1;

            for (int j = 1; j <= i; j++) {
                if(arr[j] < arr[i] && dp[j] >= dp[i])
                    dp[i] = dp[j] + 1;
            }
        }

        int max = -1;
        for (int i = 1; i <= N; i++) {
            if(dp[i] > max)
                max = dp[i];
        }

        out.write(String.valueOf(max));
        out.flush();
        out.close();
    }
}
