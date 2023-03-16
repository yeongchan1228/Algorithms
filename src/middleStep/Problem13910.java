package middleStep;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem13910 { // 개업
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[m];
        int[] dp = new int[n + 1];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j) {
                    dp[arr[i]] = 1;
                    continue;
                }

                if (arr[i] + arr[j] <= n) {
                    dp[arr[i] + arr[j]] = 1;
                }
            }
        }


        for (int i = 1; i <= n; i++) {
            if (dp[i] == 1) {
                continue;
            }

            for (int j = 1; j <= i / 2; j++) {
                if (dp[j] == -1 || dp[i - j] == -1) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
            }

            if (dp[i] == Integer.MAX_VALUE) {
                dp[i] = -1;
            }
        }

        out.write(String.valueOf(dp[n]));
        out.flush();
        in.close();
        out.close();
    }
}
