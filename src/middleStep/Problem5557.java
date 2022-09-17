package middleStep;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by YC on 2022/09/17.
 */
public class Problem5557 { // 1학년
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        final int limit = 21;
        int n = Integer.parseInt(in.readLine());

        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[n][limit];
        dp[0][nums[0]] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < limit; j++) {
                if (dp[i - 1][j] != 0) {
                    int sum = j + nums[i];
                    int sub = j - nums[i];

                    if (sum < limit) {
                        dp[i][sum] += dp[i - 1][j];
                    }

                    if (sub > -1) {
                        dp[i][sub] += dp[i - 1][j];
                    }
                }
            }
        }

        out.write(String.valueOf(dp[n - 2][nums[n - 1]]));
        out.flush();
        out.close();
    }
}
