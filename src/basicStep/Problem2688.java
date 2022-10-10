package basicStep;

import java.io.*;

/**
 * Created by YC on 2022/10/10.
 */
public class Problem2688 { // 줄어들지 않아
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        final int MAX = 65;
        final int NUM_MAX = 10;
        int n = Integer.parseInt(in.readLine());

        long[][] dp = new long[NUM_MAX][MAX];
        for (int i = 0; i < NUM_MAX; i++) {
            dp[i][1] = 1;
        }

        for (int i = 2; i < MAX; i++) {
            for (int j = 0; j < NUM_MAX; j++) {
                for (int k = j; k < NUM_MAX; k++) {
                    dp[j][i] += dp[k][i - 1];
                }
            }
        }

        StringBuilder result = new StringBuilder();
        while (n --> 0) {
            int num = Integer.parseInt(in.readLine());
            long save = 0;
            for (int i = 0; i < NUM_MAX; i++) {
                save += dp[i][num];
            }
            result.append(save + "\n");
        }

        out.write(result.toString());
        out.flush();
        out.close();
    }
}
