package basicStep;

import java.io.*;

/**
 * Created by YC on 2022/10/07.
 */
public class Problem2302 { // 극장 좌석
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        final int max = 41;

        int n = Integer.parseInt(in.readLine());
        int m = Integer.parseInt(in.readLine());

        int[] dp = new int[max];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < max; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int save = 0;
        int result = 1;
        for (int i = 0; i < m; i++) {
            int mvpNum = Integer.parseInt(in.readLine());

            result *= dp[mvpNum - save - 1];
            save = mvpNum;
        }
        result *= dp[n - save];

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }
}
