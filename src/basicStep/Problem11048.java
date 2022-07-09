package basicStep;

import java.io.*;
import java.util.StringTokenizer;

public class Problem11048 { // 이동하기
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[][] dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                int val = Integer.parseInt(st.nextToken());
                map[i][j] = val;
                dp[i][j] = val;
            }
        }

        for (int i = 1; i < M; i++) {
            dp[0][i] += dp[0][i - 1];
        }
        for (int i = 1; i < N; i++) {
            dp[i][0] += dp[i - 1][0];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
            int max = 0;
                for (int k = 0; k < 3; k++) {
                    max = Math.max(dp[i - 1][j - 1] + map[i][j] , dp[i - 1][j] + map[i][j]);
                    max = Math.max(max , dp[i][j - 1] + map[i][j]);
                }
                dp[i][j] = max;
            }
        }

        System.out.println(dp[N - 1][M - 1]);
    }
}
