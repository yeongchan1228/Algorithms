package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1010 { // 다리 놓기
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());

        int maxE = 0;
        int[][] cases = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int w = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            cases[i][0] = w;
            cases[i][1] = e;

            maxE = Math.max(maxE, e);
        }

        int[][] dp = new int[maxE + 1][maxE + 1];
        for (int i = 0; i <= maxE; i++) {
            dp[i][i] = 1;
            dp[i][0] = 1;
        }
        for (int i = 1; i <= maxE; i++) {
            for (int j = 1; j <= maxE; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(dp[cases[i][1]][cases[i][0]] + "\n");
        }

        out.write(result.toString());
        out.flush();
        out.close();
    }
}
