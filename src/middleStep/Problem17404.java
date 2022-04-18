package middleStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem17404 { // RGB 거리2
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(in.readLine());
        int[][] map = new int[N + 1][3];
        int[][] dp = new int[N + 1][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < 3; j++) {
                map[i + 1][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = Integer.MAX_VALUE;
        for (int start = 0; start < 3; start++) {

            for (int n = 0; n < 3; n++) {
                if(start == n) {
                    dp[1][n] = map[1][n];
                }
                else dp[1][n] = 1001;
            }

            for (int i = 2; i <= N; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + map[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + map[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + map[i][2];
            }

            for (int i = 0; i < 3; i++) {
                if(i == start)
                    continue;
                else
                    result = Math.min(result, dp[N][i]);
            }
        }

        out.write(String.valueOf(result));
        out.flush();
        out.close();
    }
}
